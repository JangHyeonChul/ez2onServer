package com.example.ez2onservertest.domain.kakaologin;

import lombok.Data;

/**
 * File Name : LoginAccessTokenDTO
 * Description : 소셜 로그인 수행을 위한 데이터 DTO
 * Update : 2023-08-10
 * Author : JHC
 */

@Data
public class LoginAccessTokenDTO {

    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expries_in;

}
