package com.example.ez2onservertest.domain.main;

import com.example.ez2onservertest.global.musicDB.MusicDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainAPI {

    MusicService musicService;

    public MainAPI(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/rank/total")
    public List<MusicDTO> getTotalRank() {
        return musicService.getAllMusics();
    }

    @GetMapping("/rank/dlc")
    public List<MusicDTO> getDLCRank(@RequestParam("dlcnumber") int dlcNumber) {

        return musicService.getDlcTypeMusics(dlcNumber);


    }
}

