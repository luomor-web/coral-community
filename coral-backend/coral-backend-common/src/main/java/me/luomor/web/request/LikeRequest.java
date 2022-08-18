package me.luomor.web.request;

import lombok.Data;
import me.luomor.enums.EnumLikeTargetType;

import javax.validation.constraints.NotNull;

@Data
public class LikeRequest {

    @NotNull
    private EnumLikeTargetType targetType;

    @NotNull
    private Long targetId;
}
