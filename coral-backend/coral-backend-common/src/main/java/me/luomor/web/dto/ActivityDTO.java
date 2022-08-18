package me.luomor.web.dto;

import lombok.Data;
import me.luomor.dbo.ActivityDBO;

@Data
public class ActivityDTO extends ActivityDBO {

    private Boolean hasJoined;
}
