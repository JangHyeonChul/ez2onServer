package com.example.ez2onservertest.domain.kakaologin;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.net.http.HttpRequest;

/**
 * File Name : LoginController
 * Description : 로그인 담당 Controller
 * Update : 2023-08-10
 * Author : JHC
 */

@Controller
@Slf4j
public class LoginController {

    @Autowired
    LoginKakaoProperties loginKakaoProperties;
    
    LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    /*
    * Mapping URL : /login
    * Http Method : GET
    * 기능 : 로그인 수행요청
    */

    @GetMapping("/login")
    public String login(HttpServletRequest request) {

        String kaKaoLoginRequest = loginService.getKaKaoLoginRequestURI();
        String remoteAddr = request.getRemoteAddr();


        log.info("[요청 IP : {}] 로그인 시도", remoteAddr);
        log.debug("[요청 IP : {}] [카카오 로그인 요청 URI : {}] 로그인 시도 ", remoteAddr, kaKaoLoginRequest);


        return "redirect:"+kaKaoLoginRequest;

    }

    /*
     * Mapping URL : /login/oauth/kakaologin
     * Http Method : GET
     * 기능 : 로그인 수행 요청결과 로그인 성공시 받은 accessCode를 이용해 로그인 작업수행
     */

    @GetMapping("/login/oauth/kakaologin")
    public String kakaologin(@RequestParam("code") String accessCode, HttpServletRequest request) {

        String token = loginService.getKakaoToken(accessCode, request);
        UserInfoDTO userInfo = loginService.getUserInfo(token, request);
        String remoteAddr = request.getRemoteAddr();
        loginService.login(userInfo, request);

        log.info("[요청 IP : {}] 로그인 완료", remoteAddr);

        return "redirect:/";
    }

    /*
     * Mapping URL : /logout
     * Http Method : POST
     * 기능 : 세션에 연결되어있는 로그인정보 로그아웃 수행
     */

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        loginService.logout(request);

        log.info("[요청 IP : {}] 로그아웃 성공", remoteAddr);

        return "redirect:/";
    }
}
