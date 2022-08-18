package me.luomor.web.request;

import lombok.Data;
import me.luomor.enums.EnumFollowTargetType;
import me.luomor.enums.EnumFriendType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class QueryFriendRequest {

    @NotNull
    private EnumFriendType friendType;

    @NotNull
    @Min(1)
    private Integer pageNo;

    @NotNull
    @Min(1)
    @Max(20)
    private Integer pageSize;
}
