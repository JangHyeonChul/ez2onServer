package com.example.ez2onservertest.domain.kakaologin;

import lombok.Data;

import java.util.List;

/**
 * File Name : UserInfoDTO
 * Description : 소셜 로그인에 성공한 유저의 Profile을 담는 DTO
 * Update : 2023-08-10
 * Author : JHC
 */


@Data
public class UserInfoDTO {

    public String id;
    public String connected_at;
    public Properties properties;


    @Data
    public class Properties {
        public String nickname;
        public String profile_image;
        public String thumbnail_image;
    }

}
