package me.luomor.web.dto;

import lombok.Data;
import me.luomor.dbo.UserDBO;
import org.joda.time.DateTime;

@Data
public class UserDTO extends UserDBO {

    private Boolean hasFollowed;
}
