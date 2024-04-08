package com.tiwatch.shared.api;

import static com.tiwatch.shared.Constants.LOGIN_ROUTE;

import com.tiwatch.shared.ApiResponse;
import com.tiwatch.shared.LoginModel;
import com.tiwatch.shared.LoginRequest;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Chandan Jana on 05-10-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
public interface ApiService {

    @POST(LOGIN_ROUTE)
    Response<ApiResponse<LoginModel>> login(@Body LoginRequest loginRequest);
}
