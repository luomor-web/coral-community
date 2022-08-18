package me.luomor.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luomor.web.dto.RepostUserDTO;
import me.luomor.web.dto.UserDTO;
import me.luomor.web.request.CancelLikeRequest;
import me.luomor.web.request.LikeRequest;
import me.luomor.web.request.QueryLikeUserRequest;
import me.luomor.web.request.QueryRepostUserRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(description = "点赞")
@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @ApiOperation(value = "点赞")
    @PostMapping(value = "/like")
    public BaseResponse like(@Valid @RequestBody LikeRequest request) {

        likeService.like(request);
        return new BaseResponse();
    }

    @ApiOperation(value = "取消点赞")
    @PostMapping(value = "/cancelLike")
    public BaseResponse cancelLike(@Valid @RequestBody CancelLikeRequest request) {

        likeService.cancelLike(request);
        return new BaseResponse();
    }

    @ApiOperation(value = "查询点赞用户")
    @PostMapping(value = "/queryLikeUser")
    public BaseResponse<List<UserDTO>> queryLikeUser(@Valid @RequestBody QueryLikeUserRequest request) {

        return likeService.queryLikeUser(request);
    }

}
