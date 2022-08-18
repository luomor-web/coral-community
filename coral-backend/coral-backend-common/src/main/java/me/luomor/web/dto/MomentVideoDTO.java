package me.luomor.web.dto;

import lombok.Data;
import me.luomor.dbo.MomentVideoDBO;

@Data
public class MomentVideoDTO extends MomentVideoDBO {

    private Boolean hasCollected;

}
