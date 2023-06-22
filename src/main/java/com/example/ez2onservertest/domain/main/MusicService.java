package com.example.ez2onservertest.domain.main;




import com.example.ez2onservertest.global.musicDB.MusicDTO;

import java.util.List;

public interface MusicService {

    List<MusicDTO> getAllMusics();
    MusicDTO getMusic(int musicNumber);
    List<MusicDTO> getDlcTypeMusics(int dlcNumber);
    List<MusicDTO> getSearch(String keyword);
}
