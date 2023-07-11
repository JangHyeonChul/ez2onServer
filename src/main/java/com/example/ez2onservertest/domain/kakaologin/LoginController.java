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

@Controller
@Slf4j
public class LoginController {

    @Autowired
    LoginKakaoProperties loginKakaoProperties;
    
    LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/login")
    public String login() {

        String kaKaoLoginRequest = loginService.getKaKaoLoginRequestURI();

        return "redirect:"+kaKaoLoginRequest;

    }

    @GetMapping("/login/oauth/kakaologin")
    public String kakaologin(@RequestParam("code") String accessCode, HttpServletRequest request) {

        String token = loginService.getKakaoToken(accessCode);
        UserInfoDTO userInfo = loginService.getUserInfo(token);
        loginService.login(userInfo, request);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        loginService.logout(request);
        return "redirect:/";
    }
}
