package com.tiwatch.shared.di;

import static com.tiwatch.shared.Constants.BASE_URL;
import static com.tiwatch.shared.Constants.OK_HTTP_TIMEOUT;

import com.tiwatch.shared.api.ApiService;
import com.tiwatch.shared.api.socketio.AuthenticationInterceptor;
import com.tiwatch.shared.api.socketio.SocketIOUtils;

import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import io.socket.client.IO;
import io.socket.client.Socket;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chandan Jana on 07-11-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    ApiService provideApiService(OkHttpClient okhttpClient) {
        return  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .build()
                .create(ApiService.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(AuthenticationInterceptor authenticationInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(authenticationInterceptor)
                .connectTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }


    @Provides
    @Singleton
    SocketIOUtils provideSocketIO(Socket io) {
        return new SocketIOUtils(io);
    }

    @Provides
    @Singleton
    Socket provideIo() {
        try {
            return IO.socket(BASE_URL);
        }catch (URISyntaxException e){
            return null;
        }

    }
}
