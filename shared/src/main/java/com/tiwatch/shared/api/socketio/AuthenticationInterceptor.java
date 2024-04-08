package com.tiwatch.shared.api.socketio;

import static com.tiwatch.shared.Constants.ACCESS_TOKEN;

import androidx.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;

import kotlinx.coroutines.flow.Flow;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Chandan Jana on 07-11-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
public class AuthenticationInterceptor implements Interceptor {
    //DataStorePreferenceRepository dataStorePreferenceRepository;
    @Inject
    AuthenticationInterceptor(
            //DataStorePreferenceRepository dataStorePreferenceRepository
    ){
        //this.dataStorePreferenceRepository = dataStorePreferenceRepository;
    }
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        //Flow<String> token = dataStorePreferenceRepository.getPreference(ACCESS_TOKEN, "");
        //String token = "";
        Request request = chain.request();
        request = request.newBuilder().addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "")
                .build();
        return chain.proceed(request);
    }
}
