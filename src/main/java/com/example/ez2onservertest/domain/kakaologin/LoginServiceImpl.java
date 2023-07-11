package com.example.ez2onservertest.domain.kakaologin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



@Service
@Slf4j
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
    public String getKakaoToken(String code, HttpServletRequest request) {

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

        boolean responseSuccess = response.getStatusCode().is2xxSuccessful();
        String remoteUserId = request.getRemoteAddr();

        if (responseSuccess) {


            log.info("[요청 IP : {}] 로그인 시도 -> 액세스 토큰 Response 성공", remoteUserId);
            log.debug("[요청 IP : {}] 액세스 토큰 정보 | 상태 코드 : {}", remoteUserId, response.getStatusCode());
        }

        if (!responseSuccess) {
            log.info("[요청 IP : {}] 로그인 시도 -> 액세스 토큰 Response 실패", remoteUserId);
            log.warn("[요청 IP : {}] 액세스 토큰 정보 | 상태 코드 : {}", remoteUserId, response.getStatusCode());
        }

        LoginAccessTokenDTO result = response.getBody();
        log.debug("[요청 IP : {}] 액세스 토큰 정보 {}", remoteUserId, result);
        return result.getAccess_token();


    }

    @Override
    public UserInfoDTO getUserInfo(String token, HttpServletRequest request) {
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

        boolean responseSuccess = response.getStatusCode().is2xxSuccessful();
        String remoteUserIP = request.getRemoteAddr();

        if (responseSuccess) {
            log.info("[요청 IP : {}] 로그인 시도 -> 액세스 토큰 Response 성공 -> 유저프로필 Reponse 성공 ", remoteUserIP);
        }

        if (!responseSuccess) {
            log.info("[요청 IP : {}] 로그인 시도 -> 액세스 토큰 Response 성공 -> 유저프로필 Reponse 실패 ", remoteUserIP);
        }

        log.debug("[요청 IP : {}] 유저 프로필 정보 {}", remoteUserIP, response.getBody());


        return response.getBody();
    }



    @Override
    public void login(UserInfoDTO userInfoDTO, HttpServletRequest request) {
        String user_id = userInfoDTO.getId();
        String userInfo = loginMapper.selectUserId(user_id);
        String remoteUserIP = request.getRemoteAddr();

        if (userInfo == null) {
            loginMapper.insertLoginUser(user_id);
            log.info("[요청 IP : {}] 로그인 성공 후 최초 접속 유저데이터 저장 ", remoteUserIP);
        }


        HttpSession session = request.getSession();
        session.setAttribute("userid", userInfoDTO);
        session.setMaxInactiveInterval(1800);


        UserInfoDTO userid = (UserInfoDTO) session.getAttribute("userid");
        log.info("[요청 IP : {}] 로그인 성공 -> 세션에 유저정보 등록 성공", remoteUserIP);
        log.debug("[요청 IP : {}] 세션 유저 정보 {}", remoteUserIP, userid);
    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String remoteUserIP = request.getRemoteAddr();
        session.invalidate();

        log.info("[요청 IP : {}] 세션 종료 처리", remoteUserIP);

    }
}
