package com.example.ez2onservertest.domain.comment;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RestController
public class CommentAPI {

    CommentValid commentValid;
    CommentService commentService;

    public CommentAPI(CommentValid commentValid, CommentService commentService) {
        this.commentValid = commentValid;
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    @Transactional
    public List<CommentDTO> writeComment(@RequestBody Map<String, String> commentMap) {
        Map<String, String> errorMap = commentValid.commentValid(commentMap);
        int musicNumber = Integer.parseInt(commentMap.get("musicnumber"));

        if (errorMap.size() == 0) {
            commentService.writeComment(commentMap);
            commentService.updateLevels(musicNumber);
        }

        return commentService.getComments(musicNumber, 0);

    }

    @PostMapping("/comment/pagenation")
    public List<CommentDTO>  commentPagetion(@RequestBody Map<String, String> musicNumber) {
        int number = Integer.parseInt(musicNumber.get("musicNumber"));

        List<CommentDTO> comments = commentService.getComments(number, 0);
        return commentService.insertCommentDTOCount(comments, number);

    }

    @PostMapping("/comment/page")
    public List<CommentDTO> commentPage(@RequestBody Map<String, String> commentRequestMap) {
        int board_id = Integer.parseInt(commentRequestMap.get("board_id"));
        int offset = Integer.parseInt(commentRequestMap.get("offset"));

        List<CommentDTO> comments = commentService.getComments(board_id, offset);
        return commentService.insertCommentDTOCount(comments, board_id);
    }
}
