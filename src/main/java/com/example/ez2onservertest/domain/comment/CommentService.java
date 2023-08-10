package com.example.ez2onservertest.domain.comment;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

/**
 * File Name : CommentService
 * Description : 댓글 작성 데이터 핸들링을 위한 Service Interface
 * Update : 2023-08-10
 */


/*
 * int writeComment : 유효성 검사를 통과후 댓글을 DB에 insert하는 작업 수행 commentMap 데이터 악곡번호, 댓글내용, 평가점수, 해당버튼
 *
 * List<CommentDTO> getComments : 악곡에 해당하는 Comment를 offset(페이지네이션)에 값에 따라 불러온다
 *
 * int getCountComments : 악곡에 해당하는 Comment에 총갯수를 가져온다
 * int getCountLevels : 악곡에 해당하는 Levels
 *
 * int insertCommentDTOCount : 악곡번호에 해당하는 댓글수를 가져온다 (페이지네이션 연산을 위한 값)
 * void updateLevels : commentMap에 담긴 악곡번호에 평가점수 업데이트 수행
 * double getScoretally : 평가점수 집계 수행
 * */

public interface CommentService {

    int writeComment(Map<String, String> commentMap, HttpServletRequest request);
    List<CommentDTO> getComments(int musicNumber, int offset);
    int getCountComments(int musicNumber);
    int getCommentLevels(int musicNumber);

    List<CommentDTO> insertCommentDTOCount(List<CommentDTO> commentDTO, int number);
    void updateLevels(Map<String, String> commentMap, HttpServletRequest request);
    double getScoreTally(int musicNumber, HttpServletRequest request);
}
