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
        List<MusicDTO> allMusics = musicService.getAllMusics();
        return allMusics;
    }

    @GetMapping("/rank/dlc")
    public List<MusicDTO> getDLCRank(@RequestParam("dlcnumber") int dlcNumber) {

        return musicService.getDlcTypeMusics(dlcNumber);

    }

    @GetMapping("/search")
    public List<MusicDTO> getSearch(@RequestParam("keyword") String keyword) {
        List<MusicDTO> search = musicService.getSearch(keyword);
        return search;
    }

    @GetMapping("/rank/key")
    public List<MusicDTO> getKeyRank(@RequestParam("keyvalue") String keyValue) {
        if (keyValue.equals("4K")) {
            return musicService.get4KAllMusics();
        }

        if (keyValue.equals("5K")) {
            return musicService.get5KAllMusics();
        }

        if (keyValue.equals("6K")) {
            return musicService.get6KAllMusics();
        }

        if (keyValue.equals("8K")) {
            return musicService.get8KAllMusics();
        }
        return null;
    }
}

