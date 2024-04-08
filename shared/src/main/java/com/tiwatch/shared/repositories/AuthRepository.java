package com.tiwatch.shared.repositories;

import com.tiwatch.shared.ApiResponse;
import com.tiwatch.shared.LoginModel;
import com.tiwatch.shared.LoginRequest;
import com.tiwatch.shared.Resource;

import kotlinx.coroutines.flow.Flow;

/**
 * Created by Chandan Jana on 05-10-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
public interface AuthRepository {
    Flow<Resource<ApiResponse<LoginModel>>> login(LoginRequest loginRequest);
}
