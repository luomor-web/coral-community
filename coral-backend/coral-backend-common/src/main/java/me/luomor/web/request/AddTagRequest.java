package me.luomor.web.request;

import lombok.Data;
import me.luomor.enums.EnumTagRelationEntityType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddTagRequest {

    @NotNull
    private EnumTagRelationEntityType entityType;

    @NotBlank
    private String name;
}
