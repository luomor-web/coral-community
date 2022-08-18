package me.luomor.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luomor.web.dto.FriendCountDTO;
import me.luomor.web.dto.UserDTO;
import me.luomor.web.request.CancelFollowRequest;
import me.luomor.web.request.FollowRequest;
import me.luomor.web.request.QueryFriendRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(description = "关注")
@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @ApiOperation(value = "关注")
    @PostMapping(value = "/follow")
    public BaseResponse follow(@Valid @RequestBody FollowRequest request) {

        followService.follow(request);
        return new BaseResponse();
    }

    @ApiOperation(value = "取消关注")
    @PostMapping(value = "/cancelFollow")
    public BaseResponse cancelFollow(@Valid @RequestBody CancelFollowRequest request) {

        followService.cancelFollow(request);
        return new BaseResponse();
    }

    @ApiOperation(value = "查询好友")
    @PostMapping(value = "/queryFriend")
    public BaseResponse<List<UserDTO>> queryFriend(@Valid @RequestBody QueryFriendRequest request) {

        return followService.queryFriend(request);
    }

    @ApiOperation(value = "查询好友个数")
    @PostMapping(value = "/countFriend")
    public BaseResponse<FriendCountDTO> countFriend() {

        return followService.countFriend();
    }

}
