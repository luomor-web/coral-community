package me.luomor.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luomor.web.dto.MomentDTO;
import me.luomor.web.dto.MomentImageDTO;
import me.luomor.web.request.QuerySquareImageRequest;
import me.luomor.web.request.QuerySquareMomentRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.ActivityService;
import me.luomor.web.service.MomentService;
import me.luomor.web.service.UserService;
import me.luomor.web.service.VideoService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Api(description = "广场")
@RestController
@RequestMapping("/square")
public class SquareController {

    @Autowired
    private MomentService momentService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询广场动态")
    @PostMapping(value = "/querySquareMoment")
    public BaseResponse<List<MomentDTO>> querySquareMoment(@Valid @RequestBody QuerySquareMomentRequest request) {
        return momentService.querySquareMoment(request);
    }

    @ApiOperation(value = "查询广场相册")
    @PostMapping(value = "/querySquareImage")
    public BaseResponse<TreeMap<String, List<MomentImageDTO>>> querySquareImage(@Valid @RequestBody QuerySquareImageRequest request) {
        return momentService.querySquareImage(request);
    }
}
