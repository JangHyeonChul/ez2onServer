package com.example.ez2onservertest.domain.kakaologin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Map;


@Service
public class LoginServiceImpl implements LoginService {

    LoginMapper loginMapper;

    public LoginServiceImpl(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    private static final String TOKEN_URI = "https://kauth.kakao.com/oauth/token";
    private static final String REDIRECT_URI = "http://ez2level.kro.kr/oauth";
    private static final String GRANT_TYPE = "authorization_code";
    private static final String CLIENT_ID = "fcc1110f8bd54e8c77c6821b89f9095e";


    private static final String URI_STRING = "https://kauth.kakao.com";
    private static final String AUTH_PATH = "/oauth/authorize?";
    private static final String TOKEN_PATH = "/oauth/token?";


    private static final String RESPONSE_TYPE = "code";
    private static final String AUTH_REDIRECT_URI = "http://ez2level.kro.kr/login/oauth/kakaologin";
    private static final String TOKEN_REDIRECT_URI = "http://ez2level.kro.kr/";


    @Override
    public String getKaKaoLoginRequestURI() {

        StringBuffer uri = new StringBuffer();
        uri.append(URI_STRING)
                .append(AUTH_PATH)
                .append("response_type=" + RESPONSE_TYPE)
                .append("&client_id=" + CLIENT_ID)
                .append("&redirect_uri=" + AUTH_REDIRECT_URI);

        return uri.toString();


    }

    @Override
    public String getKakaoToken(String code) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers  = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "fcc1110f8bd54e8c77c6821b89f9095e");
        params.add("redirect_uri", "http://ez2level.kro.kr/login/oauth/kakaologin");
        params.add("code", code);


        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        ResponseEntity<LoginAccessTokenDTO> response = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                LoginAccessTokenDTO.class
        );

        LoginAccessTokenDTO result = response.getBody();
        return result.getAccess_token();


    }

    @Override
    public UserInfoDTO getUserInfo(String token) {
        HttpHeaders headers  = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

        RestTemplate rt = new RestTemplate();
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, headers);
        ResponseEntity<UserInfoDTO> response = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                httpEntity,
                UserInfoDTO.class
        );


        return response.getBody();
    }



    @Override
    public void login(UserInfoDTO userInfoDTO, HttpServletRequest request) {
        String user_id = userInfoDTO.getId();
        String userInfo = loginMapper.selectUserId(user_id);

        if (userInfo == null) {
            loginMapper.insertLoginUser(user_id);
        }

        HttpSession session = request.getSession();
        session.setAttribute("userid", userInfoDTO);
        session.setMaxInactiveInterval(1800);

    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

    }
}
