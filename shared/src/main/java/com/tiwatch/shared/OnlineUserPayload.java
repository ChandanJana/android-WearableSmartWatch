package com.tiwatch.shared;

/**
 * Created by Chandan Jana on 07-11-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
public class OnlineUserPayload {
    OnlineUserPayload(String userId){
        this.userId = userId;
    }
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        userId = userId;
    }
}
