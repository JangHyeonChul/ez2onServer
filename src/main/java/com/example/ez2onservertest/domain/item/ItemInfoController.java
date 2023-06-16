package com.example.ez2onservertest.domain.item;


import com.example.ez2onservertest.domain.main.MusicService;
import com.example.ez2onservertest.global.musicDB.MusicDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemInfoController {

    MusicService musicService;

    public ItemInfoController(MusicService music) {
        this.musicService = music;
    }

    @GetMapping("/music/{musicNumber}")
    public String itemInfo(@PathVariable("musicNumber")int musicNumber, Model model) {

        MusicDTO music = musicService.getMusic(musicNumber);


        model.addAttribute("music", music);
        model.addAttribute("musicNumber", musicNumber);
        return "item-info";
    }
}
