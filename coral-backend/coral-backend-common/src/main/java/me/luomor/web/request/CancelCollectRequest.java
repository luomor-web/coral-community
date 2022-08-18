package me.luomor.web.request;

import lombok.Data;
import me.luomor.enums.EnumCollectTargetType;

import javax.validation.constraints.NotNull;

@Data
public class CancelCollectRequest {

    @NotNull
    private EnumCollectTargetType targetType;

    @NotNull
    private Long targetId;
}
