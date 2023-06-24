package com.example.ez2onservertest.domain.main;


import com.example.ez2onservertest.global.musicDB.MusicDTO;
import com.example.ez2onservertest.global.musicDB.MusicKeyLevelDTO;
import com.example.ez2onservertest.global.musicDB.MusicMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MusicServiceImpl implements MusicService {

    MusicMapper music;

    public MusicServiceImpl(MusicMapper music) {
        this.music = music;
    }

    @Override
    public List<MusicDTO> getAllMusics() {
        List<MusicDTO> allMusics = music.selectAllMusics();
        allMusics.stream().forEach( (i) -> {
            float reLevel = i.getRe_level();
            i.setSelectLevel(reLevel);
        });

        return allMusics;
    }

    @Override
    public MusicDTO getMusic(int musicNumber) {
        return music.selectMusic(musicNumber);
    }

    @Override
    public List<MusicDTO> getDlcTypeMusics(int dlcNumber) {
        return music.selectDlcTypeMusics(dlcNumber);
    }

    @Override
    public List<MusicDTO> getSearch(String keyword) {
        String result = keyword.trim();
        return music.selectSearch(result);
    }

    @Override
    public List<MusicDTO> get4KAllMusics() {
        List<MusicDTO> allMusics = music.select4BtnAllMusics();
        allMusics.stream().forEach( (i) -> {
            float reLevel = i.getLevel_4K();
            i.setSelectLevel(reLevel);
        });
        return allMusics;
    }

    @Override
    public List<MusicDTO> get5KAllMusics() {
        List<MusicDTO> allMusics = music.select5BtnAllMusics();
        allMusics.stream().forEach( (i) -> {
            float reLevel = i.getLevel_5K();
            i.setSelectLevel(reLevel);
        });
        return allMusics;
    }

    @Override
    public List<MusicDTO> get6KAllMusics() {
        List<MusicDTO> allMusics = music.select6BtnAllMusics();
        allMusics.stream().forEach( (i) -> {
            float reLevel = i.getLevel_6K();
            i.setSelectLevel(reLevel);
        });
        return allMusics;
    }

    @Override
    public List<MusicDTO> get8KAllMusics() {
        List<MusicDTO> allMusics = music.select8BtnAllMusics();
        allMusics.stream().forEach( (i) -> {
            float reLevel = i.getLevel_8K();
            i.setSelectLevel(reLevel);
        });
        return allMusics;
    }

    @Override
    public MusicKeyLevelDTO getKeyLevels(int musicNumber) {
        return music.selectLevels(musicNumber);
    }


}
