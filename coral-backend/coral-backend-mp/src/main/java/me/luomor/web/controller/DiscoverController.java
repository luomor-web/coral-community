package me.luomor.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luomor.web.dto.MomentDTO;
import me.luomor.web.request.PageRequest;
import me.luomor.web.request.QuerySquareMomentRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.ActivityService;
import me.luomor.web.service.MomentService;
import me.luomor.web.service.UserService;
import me.luomor.web.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(description = "发现")
@RestController
@RequestMapping("/discover")
public class DiscoverController {

    @Autowired
    private MomentService momentService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询好友动态")
    @PostMapping(value = "/queryFriendMoment")
    public BaseResponse<List<MomentDTO>> queryFriendMoment(@Valid @RequestBody PageRequest request) {
        return momentService.queryFriendMoment(request);
    }

}
