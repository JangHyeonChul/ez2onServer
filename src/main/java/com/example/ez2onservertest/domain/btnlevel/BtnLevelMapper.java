package com.example.ez2onservertest.domain.btnlevel;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BtnLevelMapper {

    BtnLevelDTO selectBtnLevel(int musicNumber);
}
