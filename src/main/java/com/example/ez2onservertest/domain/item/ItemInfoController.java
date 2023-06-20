package com.example.ez2onservertest.domain.item;


import com.example.ez2onservertest.domain.btnlevel.BtnLevelService;
import com.example.ez2onservertest.domain.comment.CommentDTO;
import com.example.ez2onservertest.domain.comment.CommentService;
import com.example.ez2onservertest.domain.main.MusicService;
import com.example.ez2onservertest.global.musicDB.MusicDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ItemInfoController {

    MusicService musicService;
    CommentService commentService;
    BtnLevelService btnLevelService;

    public ItemInfoController(MusicService musicService, CommentService commentService, BtnLevelService btnLevelService) {
        this.musicService = musicService;
        this.commentService = commentService;
        this.btnLevelService = btnLevelService;
    }

    @GetMapping("/music/{musicNumber}")
    public String itemInfo(@PathVariable("musicNumber")int musicNumber, Model model) {

        MusicDTO music = musicService.getMusic(musicNumber);
        List<CommentDTO> comments = commentService.getComments(musicNumber, 0);
        List<List<String>> btnLevels = btnLevelService.getBtnLevel(musicNumber);

        model.addAttribute("btnlevels", btnLevels);
        model.addAttribute("music", music);
        model.addAttribute("comments", comments);
        model.addAttribute("musicNumber", musicNumber);
        return "item-info";
    }
}
