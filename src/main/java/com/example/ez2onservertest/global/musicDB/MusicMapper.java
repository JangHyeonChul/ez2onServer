package com.example.ez2onservertest.global.musicDB;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicMapper {

    List<MusicDTO> selectAllMusics();

}