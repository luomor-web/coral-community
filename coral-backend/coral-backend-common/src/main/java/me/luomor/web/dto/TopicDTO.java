package me.luomor.web.dto;

import lombok.Data;
import me.luomor.dbo.CommentDBO;
import me.luomor.dbo.TopicDBO;

@Data
public class TopicDTO extends TopicDBO {

    private String createUserName;

    private String lastUpdateUserName;

    private Integer momentCount;

    private Integer userCount;

}
