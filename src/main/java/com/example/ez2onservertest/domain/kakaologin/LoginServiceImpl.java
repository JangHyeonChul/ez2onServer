package com.example.ez2onservertest.domain.kakaologin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



@Service
public class LoginServiceImpl implements LoginService {

    LoginMapper loginMapper;
    LoginKakaoProperties kakaoProperties;

    public LoginServiceImpl(LoginMapper loginMapper, LoginKakaoProperties loginKakaoProperties) {
        this.loginMapper = loginMapper;
        this.kakaoProperties = loginKakaoProperties;
    }



    @Override
    public String getKaKaoLoginRequestURI() {

        String uriString = kakaoProperties.getUri();
        String authPath = kakaoProperties.getAuth_path();
        String responseType = kakaoProperties.getResponse_type();
        String clientId = kakaoProperties.getClient_Id();
        String authRedirectUri = kakaoProperties.getAuth_redirect_uri();

        StringBuffer uri = new StringBuffer();
        uri.append(uriString)
                .append(authPath)
                .append("response_type=" + responseType)
                .append("&client_id=" + clientId)
                .append("&redirect_uri=" + authRedirectUri);

        return uri.toString();


    }

    @Override
    public String getKakaoToken(String code) {

        String grantType = kakaoProperties.getGrant_type();
        String clientId = kakaoProperties.getClient_Id();
        String authRedirectUri = kakaoProperties.getAuth_redirect_uri();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers  = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", grantType);
        params.add("client_id", clientId);
        params.add("redirect_uri", authRedirectUri);
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
