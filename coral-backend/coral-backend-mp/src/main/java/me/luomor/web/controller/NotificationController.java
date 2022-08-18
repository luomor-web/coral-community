package me.luomor.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luomor.web.dto.AtNotificationDTO;
import me.luomor.web.dto.CommentNotificationDTO;
import me.luomor.web.request.ClearNotificationCountRequest;
import me.luomor.web.request.PageRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(description = "通知")
@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @ApiOperation(value = "查询评论信息")
    @PostMapping(value = "/queryCommentInfo")
    public BaseResponse<List<CommentNotificationDTO>> queryCommentInfo(@Valid @RequestBody PageRequest request) {
        return notificationService.queryCommentInfo(request);
    }

    @ApiOperation(value = "查询@我信息")
    @PostMapping(value = "/queryAtInfo")
    public BaseResponse<List<AtNotificationDTO>> queryAtInfo(@Valid @RequestBody PageRequest request) {
        return notificationService.queryAtInfo(request);
    }

    @ApiOperation(value = "查询通知信息")
    @PostMapping(value = "/queryNotificationInfo")
    public BaseResponse<List<AtNotificationDTO>> queryNotificationInfo(@Valid @RequestBody PageRequest request) {
        return notificationService.queryAtInfo(request);
    }

    @ApiOperation(value = "清空通知数量")
    @PostMapping(value = "/clearNotificationCount")
    public BaseResponse clearNotificationCount(@Valid @RequestBody ClearNotificationCountRequest request) {
        return notificationService.clearNotificationCount(request);
    }

}
