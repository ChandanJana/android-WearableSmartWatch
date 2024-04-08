package com.tiwatch.shared;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Chandan Jana on 05-10-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */

public class NetworkHelper {

    public static <T> void makeNetworkCall(Call<ApiResponse<T>> call, NetworkCallback<T> callback) {
        /*try {
            Response<ApiResponse<T>> response = call.execute();
            if (response.isSuccessful()){
                ApiResponse<T> apiResponse = response.body();
                callback.onSuccess(apiResponse);
            }else {
                String errorBody = null;
                try {
                    errorBody = response.errorBody().string();
                    ApiResponse<?> errorResponse = new Gson().fromJson(errorBody, ApiResponse.class);
                    callback.onError(errorResponse.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                    callback.onError("Error parsing error response");
                }
            }
        }catch (IOException ioException){
            callback.onError("Network request failed: " + ioException.getMessage());
        }*/

        call.enqueue(new Callback<ApiResponse<T>>() {
            @Override
            public void onResponse(Call<ApiResponse<T>> call, Response<ApiResponse<T>> response) {
                if (response.isSuccessful()) {
                    ApiResponse<T> apiResponse = response.body();
                    callback.onSuccess(apiResponse);
                } else {
                    String errorBody = null;
                    try {
                        errorBody = response.errorBody().string();
                        ApiResponse<?> errorResponse = new Gson().fromJson(errorBody, ApiResponse.class);
                        callback.onError(errorResponse.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                        callback.onError("Error parsing error response");
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<T>> call, Throwable t) {
                callback.onError("Network request failed: " + t.getMessage());
            }
        });
    }

    public interface NetworkCallback<T> {
        void onSuccess(ApiResponse<T> response);

        void onError(String errorMessage);
    }
}
