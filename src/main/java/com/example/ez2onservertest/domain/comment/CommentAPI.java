package com.example.ez2onservertest.domain.comment;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
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
    public List<CommentDTO> writeComment(@RequestBody Map<String, String> commentMap, HttpServletRequest request) {
        log.info("[요청 IP : {}] 코멘트 등록 요청", request.getRemoteAddr());

        Map<String, String> errorMap = commentValid.commentValid(commentMap, request);
        int musicNumber = Integer.parseInt(commentMap.get("musicnumber"));

        if (errorMap.size() == 0) {
            log.info("[요청 IP : {}] 코멘트 등록 유효성 검사 통과", request.getRemoteAddr());

            commentService.writeComment(commentMap, request);

            log.info("[요청 IP : {}] {}번 악곡의 종합점수 업데이트 수행요청", request.getRemoteAddr(), musicNumber);
            commentService.updateLevels(commentMap, request);
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
