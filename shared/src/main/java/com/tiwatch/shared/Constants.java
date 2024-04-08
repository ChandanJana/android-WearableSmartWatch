package com.tiwatch.shared;

import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;

/**
 * Created by Chandan Jana on 05-10-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
public class Constants {
    private Constants() {
    }

    public static final String BASE_URL = "ws://172.16.5.149:5080/ws";
    public static final String LOGIN_ROUTE = "/auth/login";

    //socket io events
    public static final String NEW_CHAT_EVENT = "new-chat";
    public static final String CHAT_MESSAGES_EVENT = "chat-message";
    public static final String CHATS_EVENT = "chats";
    public static final String JOIN_CHAT_EVENT = "join-chat";
    public static final String ONLINE_USER_EVENT = "online";


    public static final long OK_HTTP_TIMEOUT = 30L;
    public static final Preferences.Key<String> ACCESS_TOKEN = PreferencesKeys.stringKey("token");

}
