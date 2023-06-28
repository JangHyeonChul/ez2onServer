package com.example.ez2onservertest.domain.result;

import com.example.ez2onservertest.domain.main.MusicService;
import com.example.ez2onservertest.global.musicDB.MusicDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultAPI {

    MusicService musicService;
    ResultService resultService;

    public ResultAPI(MusicService musicService, ResultService resultService) {
        this.musicService = musicService;
        this.resultService = resultService;
    }

    @GetMapping("/music")
    public MusicDTO music(@RequestParam("musicnumber") int musicNumber, HttpServletRequest request) {



        return musicService.getMusic(musicNumber);
    }

}
