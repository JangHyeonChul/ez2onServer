package com.example.ez2onservertest.domain.main;


import com.example.ez2onservertest.global.musicDB.MusicDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URI;
import java.util.List;


@Controller
@Slf4j
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
