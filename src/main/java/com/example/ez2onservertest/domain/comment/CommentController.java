package com.example.ez2onservertest.domain.comment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    CommentValid commentValid;
    CommentService commentService;

    public CommentController(CommentValid commentValid, CommentService commentService) {
        this.commentValid = commentValid;
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    @ResponseBody
    public List<CommentDTO> comment(@RequestBody Map<String, String> commentMap) {
        Map<String, String> errorMap = commentValid.commentValid(commentMap);
        int musicNumber = Integer.parseInt(commentMap.get("musicnumber"));

        if (errorMap.size() == 0) {
            commentService.writeComment(commentMap);
        }

        return commentService.getComments(musicNumber);

    }
}
