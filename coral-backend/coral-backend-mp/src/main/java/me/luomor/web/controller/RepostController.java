package me.luomor.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luomor.web.dto.RepostUserDTO;
import me.luomor.web.request.QueryRepostUserRequest;
import me.luomor.web.request.RepostRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.RepostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(description = "转发")
@RestController
@RequestMapping("/repost")
public class RepostController {

    @Autowired
    private RepostService repostService;

    @ApiOperation(value = "转发")
    @PostMapping(value = "/repost")
    public BaseResponse repost(@Valid @RequestBody RepostRequest request) {

        return repostService.repost(request);
    }

    @ApiOperation(value = "查询转发用户")
    @PostMapping(value = "/queryRepostUser")
    public BaseResponse<List<RepostUserDTO>> queryRepostUser(@Valid @RequestBody QueryRepostUserRequest request) {

        return repostService.queryRepostUser(request);
    }

}
