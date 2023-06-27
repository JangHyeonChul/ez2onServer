package com.example.ez2onservertest.domain.kakaologin;

import lombok.Data;

@Data
public class LoginAccessTokenDTO {

    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expries_in;

}
