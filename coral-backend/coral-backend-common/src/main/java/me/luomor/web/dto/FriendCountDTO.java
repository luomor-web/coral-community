package me.luomor.web.dto;

import lombok.Data;
import me.luomor.dbo.UserDBO;

@Data
public class FriendCountDTO {

    private Integer followCount;

    private Integer fansCount;

}
