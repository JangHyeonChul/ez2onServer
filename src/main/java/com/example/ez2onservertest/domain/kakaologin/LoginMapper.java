package com.example.ez2onservertest.domain.kakaologin;

import org.apache.ibatis.annotations.Mapper;

/**
 * File Name : LoginMapper
 * Description : 로그인 성공시 DB 데이터 핸들링을 위한 Mapper Interface
 * Update : 2023-08-10
 * Author : JHC
 */


@Mapper
public interface LoginMapper {

    /* 최초 로그인시 DB에 사용자의 id를 insert 작업*/
    int insertLoginUser(String id);

    /* 유저정보 테이블에 파라미터로 들어온 id를 통해 Select 작업 수행  */
    String selectUserId(String id);
}
