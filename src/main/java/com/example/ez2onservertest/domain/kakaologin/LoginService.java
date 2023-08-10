package com.example.ez2onservertest.domain.kakaologin;

import jakarta.servlet.http.HttpServletRequest;

import java.net.URI;
import java.net.http.HttpRequest;

/**
 * File Name : LoginService
 * Description : 로그인 수행 로직을 수행하는 Interface
 * Update : 2023-08-10
 * Author : JHC
 */

public interface LoginService {

    String getKaKaoLoginRequestURI();
    String getKakaoToken(String code, HttpServletRequest request);
    UserInfoDTO getUserInfo(String token, HttpServletRequest request);
    void login(UserInfoDTO userInfoDTO, HttpServletRequest request);
    void logout(HttpServletRequest request);
}
