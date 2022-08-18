package me.luomor.web.dto;

import lombok.Data;
import me.luomor.dbo.NotificationDBO;

@Data
public class CommentNotificationDTO extends NotificationDBO {

    private MomentDTO moment;

    private String commentContent;

    private String parentCommentContent;

    private String sendUserName;

    private String sendUserAvatarUrl;
}
