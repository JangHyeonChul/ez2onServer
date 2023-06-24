package com.example.ez2onservertest.domain.main;




import com.example.ez2onservertest.global.musicDB.MusicDTO;
import com.example.ez2onservertest.global.musicDB.MusicKeyLevelDTO;

import java.util.List;

public interface MusicService {

    List<MusicDTO> getAllMusics();
    MusicDTO getMusic(int musicNumber);
    List<MusicDTO> getDlcTypeMusics(int dlcNumber);
    List<MusicDTO> getSearch(String keyword);

    List<MusicDTO> get4KAllMusics();
    List<MusicDTO> get5KAllMusics();
    List<MusicDTO> get6KAllMusics();
    List<MusicDTO> get8KAllMusics();

    MusicKeyLevelDTO getKeyLevels(int musicNumber);


}
