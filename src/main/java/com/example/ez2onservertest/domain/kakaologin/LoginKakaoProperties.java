package com.example.ez2onservertest.domain.kakaologin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * File Name : LoginKakaoProperties
 * Description : 소셜 로그인을 위한 데이터 DTO application-develop.properties 및 application-prod에 보안데이터 저장
 * Update : 2023-08-10
 * Author : JHC
 */

@Getter
@Setter
@ConfigurationProperties(prefix = "kakao")
@Configuration

public class LoginKakaoProperties {

    private String client_Id;
    private String grant_type;
    private String uri;
    private String auth_path;
    private String response_type;
    private String auth_redirect_uri;

    public LoginKakaoProperties() {}
}
