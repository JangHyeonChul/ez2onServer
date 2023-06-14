package com.example.ez2onservertest.domain.main;


import com.example.ez2onservertest.global.musicDB.MusicDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MainController {

    private MusicService music;

    public MainController(MusicService music) {
        this.music = music;
    }

    @GetMapping("/")
    public String main(Model model) {
        List<MusicDTO> allMusics = music.getAllMusics();


        model.addAttribute("allMusic", allMusics);
        return "main";
    }
}
