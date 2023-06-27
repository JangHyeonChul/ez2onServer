package com.example.ez2onservertest.domain.kakaologin;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    int insertLoginUser(String id);
    String selectUserId(String id);
}
