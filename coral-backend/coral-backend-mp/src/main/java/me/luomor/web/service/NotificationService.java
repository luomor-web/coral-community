package me.luomor.web.service;

import me.luomor.dbo.NotificationDBO;
import me.luomor.web.dto.AtNotificationDTO;
import me.luomor.web.dto.CommentNotificationDTO;
import me.luomor.web.request.ClearNotificationCountRequest;
import me.luomor.web.request.PageRequest;
import me.luomor.web.response.BaseResponse;

import java.util.List;

public interface NotificationService {

    void sendNotification(NotificationDBO notification);

    BaseResponse<List<AtNotificationDTO>> queryAtInfo(PageRequest request);

    BaseResponse clearNotificationCount(ClearNotificationCountRequest request);

    BaseResponse<List<CommentNotificationDTO>> queryCommentInfo(PageRequest request);

}
