package me.luomor.web.request;

import lombok.Data;
import me.luomor.enums.EnumNotificationCategory;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ClearNotificationCountRequest {

    @NotNull
    private EnumNotificationCategory category;

}
