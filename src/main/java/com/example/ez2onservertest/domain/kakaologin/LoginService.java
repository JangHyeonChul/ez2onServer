package com.example.ez2onservertest.domain.kakaologin;

import jakarta.servlet.http.HttpServletRequest;

import java.net.URI;
import java.net.http.HttpRequest;

public interface LoginService {

    String getKaKaoLoginRequestURI();
    String getKakaoToken(String code);
    UserInfoDTO getUserInfo(String token);
    void login(UserInfoDTO userInfoDTO, HttpServletRequest request);
    void logout(HttpServletRequest request);
}
