package com.example.ez2onservertest.global.musicDB;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicMapper {

    List<MusicDTO> selectAllMusics();
    MusicDTO selectMusic(int musicNumber);
    List<MusicDTO> selectDlcTypeMusics(int dlcNumber);
    List<MusicDTO> selectSearch(String keyword);

    List<MusicDTO> select4BtnAllMusics();
    List<MusicDTO> select5BtnAllMusics();
    List<MusicDTO> select6BtnAllMusics();
    List<MusicDTO> select8BtnAllMusics();

    MusicKeyLevelDTO selectLevels(int musicNumber);

}
