package com.example.ez2onservertest.domain.kakaologin;

import lombok.Data;

import java.util.List;

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
