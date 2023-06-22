package com.example.ez2onservertest.domain.main;

import com.example.ez2onservertest.global.musicDB.MusicDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
