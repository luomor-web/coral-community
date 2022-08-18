package me.luomor.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luomor.web.dto.UserDTO;
import me.luomor.web.request.AddFeedbackRequest;
import me.luomor.web.request.GetUserInfoRequest;
import me.luomor.web.request.UpdateUserInfoRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.SettingService;
import me.luomor.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(description = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息")
    @PostMapping(value = "/getUserInfo")
    public BaseResponse<UserDTO> getUserInfo(@Valid @RequestBody GetUserInfoRequest request) {
        return userService.getUserInfo(request);
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping(value = "/updateUserInfo")
    public BaseResponse updateUserInfo(@Valid @RequestBody UpdateUserInfoRequest request) {
        return userService.updateUserInfo(request);
    }

}
