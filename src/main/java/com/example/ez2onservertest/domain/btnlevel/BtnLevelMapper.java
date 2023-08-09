package com.example.ez2onservertest.domain.btnlevel;

import org.apache.ibatis.annotations.Mapper;

/*
* selectBtnLevel : 정수형 파라미터에 해당하는 악곡 넘버의 해당하는 난이도 반환
* */


@Mapper
public interface BtnLevelMapper {

    BtnLevelDTO selectBtnLevel(int musicNumber);
}
