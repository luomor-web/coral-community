package me.luomor.web.service;

import me.luomor.web.dto.GetProfileDTO;
import me.luomor.web.dto.UserDTO;
import me.luomor.web.request.GetUserInfoRequest;
import me.luomor.web.request.UpdateUserInfoRequest;
import me.luomor.web.response.BaseResponse;

public interface UserService {

    BaseResponse<UserDTO> getUserInfo(GetUserInfoRequest request);

    BaseResponse updateUserInfo(UpdateUserInfoRequest request);
}
