package com.tiwatch.shared;

/**
 * Created by Chandan Jana on 05-10-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */

public abstract class Resource<T> {
    private T data;
    private String message;

    public Resource(T data, String message) {
        this.data = data;
        this.message = message;
    }

    // Success class
    public static class Success<T> extends Resource<T> {
        public Success(T data) {
            super(data, null);
        }
    }

    // Error class
    public static class Error<T> extends Resource<T> {
        public Error(String errorMessage) {
            super(null, errorMessage);
        }
    }

    // Loading class
    public static class Loading<T> extends Resource<T> {
        public Loading() {
            super(null, null);
        }
    }
}
