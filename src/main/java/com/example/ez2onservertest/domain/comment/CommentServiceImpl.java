package com.example.ez2onservertest.domain.comment;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService{

    CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public int writeComment(Map<String, String> commentMap, HttpServletRequest request) {
        int result = commentMapper.insertComment(commentMap);

        if (result > 0) {
            log.info("[요청 IP : {}] 코멘트 등록 성공", request.getRemoteAddr());
        }

        return result;
    }

    @Override
    public List<CommentDTO> getComments(int musicNumber, int offset) {
        return commentMapper.selectComments(musicNumber, offset);
    }

    @Override
    public int getCountComments(int musicNumber) {
        return commentMapper.countComments(musicNumber);
    }

    @Override
    public int getCommentLevels(int musicNumber) {

        return commentMapper.selectCommentsLevel(musicNumber);
    }

    @Override
    public List<CommentDTO> insertCommentDTOCount(List<CommentDTO> comments, int number) {
        int commentCount = getCountComments(number);
        comments.stream().forEach( (comment) -> {
            comment.setComment_cnt(commentCount);
        });
        return comments;
    }

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
