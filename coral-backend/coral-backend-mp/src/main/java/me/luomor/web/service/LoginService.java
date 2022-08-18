package me.luomor.web.service;

import me.luomor.web.dto.LoginUserDTO;
import me.luomor.web.request.LoginRequest;

public interface LoginService {
    LoginUserDTO login(LoginRequest request) throws Exception;
}
