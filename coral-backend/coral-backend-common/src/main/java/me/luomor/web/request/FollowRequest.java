package me.luomor.web.request;

import lombok.Data;
import me.luomor.enums.EnumFollowTargetType;

import javax.validation.constraints.NotNull;

@Data
public class FollowRequest {

    @NotNull
    private EnumFollowTargetType targetType;

    @NotNull
    private Long targetId;
}
