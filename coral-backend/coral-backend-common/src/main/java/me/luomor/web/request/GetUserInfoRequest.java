package me.luomor.web.request;

import lombok.Data;
import me.luomor.enums.EnumFeedbackType;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GetUserInfoRequest {

    private Long userId;

}
