package com.example.ez2onservertest.domain.comment;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * File Name : CommentAPI
 * Description : 댓글 작성과 관련된 API
 * Update : 2023-08-10
 */



@Controller
@Slf4j
@RestController
public class CommentAPI {

    /*
     * CommentValid : 댓글 작성 유효성 검사 ( 댓글길이, 평가점수 100을 넘었는지, -1인지, 공백여부 체크)
     * CommentService : 댓글 작성 Service Interface
     * */

    CommentValid commentValid;
    CommentService commentService;

    public CommentAPI(CommentValid commentValid, CommentService commentService) {
        this.commentValid = commentValid;
        this.commentService = commentService;
    }

    /*
    * API : /comment
    * Http Method : POST
    * 기능 : 코멘트 등록 요청 클라이언트 에서 받은 악곡번호와 댓글, 평가점수가 저장됨
    * 파라미터 : Map<String, String> commentMap
    * commentMap 안에 있는 데이터
    * musicnumber: musicNumber 악곡번호
      content: text 댓글 내용
      level: level 평가레벨
      btn: btn 해당버튼이 무슨버튼인지
    * 트랜잭션 : 코멘트 등록 요청시 악곡번호로 해당 데이터 Select 유효성 검사 통과시 댓글, 평가점수 Insert, 평가점수 종합
    */

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

    /*
    * API : /comment/pagenation
    * Http Method : POST
    * 기능 : 악곡번호에 해당하는 코멘트 페이지네이션 수행
    * 파라미터 : Map<String, String> musicNumber
    * musicNumber 안에 있는 데이터
    * musicnumber: musicNumber 악곡번호
    * 설명 : 클라이언트에서 Parameter로 받은 musicNumber에 값을 가져오고 해당 값을 정수로변환
    * 처음 댓글창 접속시 보이는 첫번째 댓글페이지에 대한 연산을 수행 (초기 오프셋이 0)
    */

    @PostMapping("/comment/pagenation")
    public List<CommentDTO>  commentPagetion(@RequestBody Map<String, String> musicNumber) {
        int number = Integer.parseInt(musicNumber.get("musicNumber"));

        List<CommentDTO> comments = commentService.getComments(number, 0);
        return commentService.insertCommentDTOCount(comments, number);

    }

    /*
     * API : /comment/page
     * Http Method : POST
     * 기능 : 페이지 네이션 수행시 Pagenation Bar 연산 수행
     * 파라미터 : Map<String, String> commentRequestMap
     * commentRequestMap 안에 있는 데이터
     * board_id: board_id 악곡 번호
       offset: offset 연산 수행시 사용되는 offset
     */

    @PostMapping("/comment/page")
    public List<CommentDTO> commentPage(@RequestBody Map<String, String> commentRequestMap) {
        int board_id = Integer.parseInt(commentRequestMap.get("board_id"));
        int offset = Integer.parseInt(commentRequestMap.get("offset"));

        List<CommentDTO> comments = commentService.getComments(board_id, offset);
        return commentService.insertCommentDTOCount(comments, board_id);
    }
}
