package me.luomor.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luomor.web.dto.MomentDetailDTO;
import me.luomor.web.request.DeleteMomentRequest;
import me.luomor.web.request.GetMomentDetailRequest;
import me.luomor.web.request.PublishMomentRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(description = "动态")
@RestController
@RequestMapping("/moment")
public class MomentController {

    @Autowired
    private MomentService momentService;

    @ApiOperation(value = "获取动态详情")
    @PostMapping(value = "/getMomentDetail")
    public BaseResponse<MomentDetailDTO> getMomentDetail(@Valid @RequestBody GetMomentDetailRequest request) {

        return momentService.getMomentDetail(request);
    }

    @ApiOperation(value = "发布动态")
    @PostMapping(value = "/publishMoment")
    public BaseResponse publishMoment(@Valid @RequestBody PublishMomentRequest request) {

        momentService.publishMoment(request);

        return new BaseResponse();
    }

    @ApiOperation(value = "删除动态")
    @PostMapping(value = "/deleteMoment")
    public BaseResponse deleteMoment(@Valid @RequestBody DeleteMomentRequest request) {

        momentService.deleteMoment(request);
        return new BaseResponse();
    }


}
