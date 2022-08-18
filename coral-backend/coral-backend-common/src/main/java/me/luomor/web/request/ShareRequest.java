package me.luomor.web.request;

import lombok.Data;
import me.luomor.enums.EnumSharePageType;

import javax.validation.constraints.NotNull;

@Data
public class ShareRequest {

    @NotNull
    private EnumSharePageType pageType;

    private Long momentId;
}
