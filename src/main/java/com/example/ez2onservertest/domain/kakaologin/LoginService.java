package com.example.ez2onservertest.domain.kakaologin;

import jakarta.servlet.http.HttpServletRequest;

import java.net.URI;
import java.net.http.HttpRequest;

public interface LoginService {

    String getKaKaoLoginRequestURI();
    String getKakaoToken(String code, HttpServletRequest request);
    UserInfoDTO getUserInfo(String token, HttpServletRequest request);
    void login(UserInfoDTO userInfoDTO, HttpServletRequest request);
    void logout(HttpServletRequest request);
}
