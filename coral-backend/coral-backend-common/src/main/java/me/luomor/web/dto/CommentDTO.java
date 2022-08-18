package me.luomor.web.dto;

import lombok.Data;
import me.luomor.dbo.CommentDBO;

@Data
public class CommentDTO extends CommentDBO {

    private String userName;

    private String userAvatarUrl;

    private Boolean hasLiked;

    private Boolean hasFollowed;

    private Integer replyCount;

    private CommentDTO replyToComment;


}
