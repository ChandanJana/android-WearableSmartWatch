package com.tiwatch.shared.repositories;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tiwatch.shared.ApiResponse;
import com.tiwatch.shared.LoginModel;
import com.tiwatch.shared.LoginRequest;
import com.tiwatch.shared.NetworkHelper;
import com.tiwatch.shared.Resource;
import com.tiwatch.shared.api.ApiService;

import javax.inject.Inject;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/**
 * Created by Chandan Jana on 05-10-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
public class AuthRepositoryImpl implements AuthRepository {

    private ApiService apiService;

    @Inject
    AuthRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Flow<Resource<ApiResponse<LoginModel>>> login(LoginRequest loginRequest) {
        /*return NetworkHelper.makeNetworkCall(apiService.login(loginRequest),
                new NetworkHelper.NetworkCallback<ApiResponse<LoginModel>>() {
                    @Override
                    public void onSuccess(ApiResponse<ApiResponse<LoginModel>> response) {
                        return;
                    }

                    @Override
                    public void onError(String errorMessage) {
                        return;
                    }
                }
        );*/
        return new Flow<Resource<ApiResponse<LoginModel>>>() {

            @Override
            public Object collect(@NonNull FlowCollector<? super Resource<ApiResponse<LoginModel>>> flowCollector, @NonNull Continuation<? super Unit> continuation) {
                return flowCollector;
            }
        };
    }
}
