package me.luomor.web.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDTO {

    private Long artistId;

    private String artistName;

    private Long userId;

    private String userName;

    private String userAvatarUrl;

    private String unionId;

    private String token;

}
