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
        return music.selectAllMusics();
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
    public MusicKeyLevelDTO getKeyLevels(int musicNumber) {
        return music.selectLevels(musicNumber);
    }
}
