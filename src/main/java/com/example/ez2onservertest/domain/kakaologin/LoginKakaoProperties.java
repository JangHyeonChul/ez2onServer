package com.example.ez2onservertest.domain.kakaologin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


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
