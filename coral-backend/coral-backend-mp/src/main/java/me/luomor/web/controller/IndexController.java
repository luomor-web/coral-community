package me.luomor.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luomor.web.dto.IndexSwiperDTO;
import me.luomor.web.dto.QueryGuessYouLikeDTO;
import me.luomor.web.dto.QueryIndexBlockDTO;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.ActivityService;
import me.luomor.web.service.IndexService;
import me.luomor.web.service.MomentService;
import me.luomor.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "首页")
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private MomentService momentService;

    @Autowired
    private IndexService indexService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询首页轮播图")
    @PostMapping(value = "/queryIndexSwiper")
    public BaseResponse<List<IndexSwiperDTO>> queryIndexSwiper() {
        return indexService.queryIndexSwiper();
    }

    @ApiOperation(value = "查询首页板块")
    @PostMapping(value = "/queryIndexBlock")
    public BaseResponse<List<QueryIndexBlockDTO>> queryIndexBlock() {
        return indexService.queryIndexBlock();
    }

    @ApiOperation(value = "查询首页板块")
    @PostMapping(value = "/queryGuessYouLike")
    public BaseResponse<List<QueryGuessYouLikeDTO>> queryGuessYouLike() {
        return indexService.queryGuessYouLike();
    }

}
