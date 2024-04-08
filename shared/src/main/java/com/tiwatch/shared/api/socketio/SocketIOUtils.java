package com.tiwatch.shared.api.socketio;

import static com.tiwatch.shared.Constants.ONLINE_USER_EVENT;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.tiwatch.shared.OnlineUserPayload;

import java.util.function.Function;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Created by Chandan Jana on 07-11-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
public class SocketIOUtils {
    Gson gson;
    Socket io;
    public SocketIOUtils(Socket io){
        gson = new Gson();
        this.io = io;
    }

    Socket connect(){

        //Timber.tag(TAG).d("Just connected to server")

        return io.connect();
    }

    Socket disconnect(){
        return io.disconnect();
    }

    <T> Emitter.Listener sendEvent(String event, T message) throws IllegalAccessException {
        if (!io.connected())
            throw new IllegalAccessException("Socket IO is not connected");

        String payload = null;

        if (message instanceof String)
            payload = (String) message;
        else
            gson.toJson(message);
        //Timber.tag(TAG).d(payload)
        io.emit(event, payload);
        return null;
    }


    boolean isConnected() {
        return io.isActive();

    }

    void joinOnlineUsers(OnlineUserPayload onlineUserPayload) {
        try {
            io.on("connect", sendEvent(ONLINE_USER_EVENT, onlineUserPayload));
        }catch (IllegalAccessException e){

        }

    }

    <T> void  onEventReceive(
            String event,
            Fragment fragment,
            Class<T> clazz
    ) throws IllegalArgumentException{
        io.on(event, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                if (event.equals("connect")) {
                    throw new IllegalArgumentException("Use onConnect function to check connection");
                }
                //if (it.isNotEmpty()) {
                    T value = gson.fromJson(args[0].toString(), clazz);
                    //fragment.lifecycleScope.launch { onReceived(value) }
                //}
            }
        });
    }
}
