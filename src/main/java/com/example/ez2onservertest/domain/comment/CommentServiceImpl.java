package com.example.ez2onservertest.domain.comment;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 * File Name : CommentServiceImpl
 * Description : 댓글 작성 데이터 핸들링을 위한 로직들의 CommentService Interface의 구현체
 * Update : 2023-08-10
 */


@Service
@Slf4j
public class CommentServiceImpl implements CommentService{

    CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }


    /*
    * 코멘트 등록을 수행하는 Method
    * commentMap - 악곡번호, 댓글내용, 평가점수, 평가를내릴버튼
    * 성공시 result 1 을 반환
    * */

    @Override
    public int writeComment(Map<String, String> commentMap, HttpServletRequest request) {
        int result = commentMapper.insertComment(commentMap);

        if (result > 0) {
            log.info("[요청 IP : {}] 코멘트 등록 성공", request.getRemoteAddr());
        }

        return result;
    }


    /*
     * musicNumber에 해당하는 댓글내용들을 불러오는 Method
     * */

    @Override
    public List<CommentDTO> getComments(int musicNumber, int offset) {
        return commentMapper.selectComments(musicNumber, offset);
    }

    /*
     * musicNumber에 해당하는 댓글들의 총갯수를 가져오는 Method
     * */


    @Override
    public int getCountComments(int musicNumber) {
        return commentMapper.countComments(musicNumber);
    }

    /*
     * musicNumber에 해당하는 댓글의 평가점수를 가져오는 Method
     * */


    @Override
    public int getCommentLevels(int musicNumber) {

        return commentMapper.selectCommentsLevel(musicNumber);
    }

    /*
     * 페이지네이션 기능을 수행하기 위한 악곡의 총 CommentDTO의 갯수를 가져오는 Method
     * */


    @Override
    public List<CommentDTO> insertCommentDTOCount(List<CommentDTO> comments, int number) {
        int commentCount = getCountComments(number);
        comments.stream().forEach( (comment) -> {
            comment.setComment_cnt(commentCount);
        });
        return comments;
    }

    /*
     * musicNumber에 해당하는 종합점수 및 키별 평가점수 업데이트 수행
     * */


    @Override
    public void updateLevels(Map<String, String> commentMap, HttpServletRequest request) {
        int musicNumber = Integer.parseInt(commentMap.get("musicnumber"));
        String keyValue = commentMap.get("btn");

        log.info("[요청 IP : {}] {}번 악곡의 종합점수 업데이트 수행", request.getRemoteAddr(), musicNumber);
        double score = getScoreTally(musicNumber, request);
        commentMapper.updateCommentLevel(musicNumber, score);

        log.info("[요청 IP : {}] {}번 악곡의 {} 종합점수 업데이트 수행", request.getRemoteAddr(), musicNumber, keyValue);
        double scoreKey = getScoreKeyTally(musicNumber, keyValue, request);
        commentMapper.updateCommentKeyLevel(musicNumber, scoreKey, keyValue);
    }


    /*
    * 평가점수 집계 로직 전체점수를 해당 댓글수로 나누어 집계수행
    * */

    @Override
    public double getScoreTally(int musicNumber, HttpServletRequest request) {
        int totalScore = getCommentLevels(musicNumber);
        int scoreCount = getCountComments(musicNumber);

        double doubleResult = (double) totalScore/scoreCount;

        DecimalFormat form = new DecimalFormat("#.##");
        double result = Double.parseDouble(form.format(doubleResult));

        log.info("[요청 IP : {}] {}번 악곡의 종합점수 {}으로 업데이트", request.getRemoteAddr(), musicNumber, result);
        return result;
    }

    /*
     * 평가점수 키별 집계 로직 전체점수를 해당 댓글수로 나누어 집계수행
     * */

    private double getScoreKeyTally(int musicNumber, String keyValue, HttpServletRequest request) {
        int keyLevels = commentMapper.selectCommentsKeyLevel(musicNumber, keyValue);
        int countKeylevels = commentMapper.countKeyComments(musicNumber, keyValue);

        double doubleResult = (double) keyLevels/countKeylevels;

        DecimalFormat form = new DecimalFormat("#.##");
        double result = Double.parseDouble(form.format(doubleResult));

        log.info("[요청 IP : {}] {}번 악곡의 {} 종합점수 {}으로 업데이트", request.getRemoteAddr(), musicNumber, keyValue, result);

        return result;


    }
}
