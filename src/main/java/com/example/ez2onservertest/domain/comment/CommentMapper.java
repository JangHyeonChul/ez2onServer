package com.example.ez2onservertest.domain.comment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * File Name : CommentMapper
 * Description : 댓글 작성 DB 데이터 핸들링을 위한 Mapper Interface
 * Update : 2023-08-10
 */



/*
 * int insertComment : 유효성 검사를 통과후 댓글을 DB에 insert하는 작업 수행 commentMap 데이터 악곡번호, 댓글내용, 평가점수, 해당버튼
 *
 * int countComments : 악곡에 해당하는 총 댓글 Count
 * int countKeyComments : 키별로 (4K, 5K, 6K, 8K) 해당하는 댓글 갯수 Count
 *
 * List<CommentDTO> selectComments : 페이지 네이션을 위한 offset 값을통해 해당하는 댓글들을 List로 불러온다
 * int selectCommentsLevel : 악곡번호에 해당하는 평가점수를 가져온다
 * int selectCommentsKeyLevel : 키별로 (4K, 5K, 6K, 8K) 악곡번호에 평가점수를 가져온다
 *
 * int updateCommentLevel : 악곡번호에 해당하는 평가점수 Update 수행
 * int updateCommentKeyLevel : 악곡번호에 해당하는 키별 평가점수 Update 수행
 * */


@Mapper
public interface CommentMapper {

    int insertComment(Map<String, String> commentMap);
    List<CommentDTO> selectComments(@Param("musicNumber") int musicNumber, @Param("offset")int offset);
    int countComments(int musicNumber);
    int countKeyComments(@Param("musicNumber")int musicNumber, @Param("keyValue")String keyValue);
    int selectCommentsLevel(int musicNumber);
    int selectCommentsKeyLevel(@Param("musicNumber")int musicNumber, @Param("keyValue")String keyValue);

    int updateCommentLevel(@Param("musicNumber")int musicNumber, @Param("score")double score);
    int updateCommentKeyLevel(@Param("musicNumber")int musicNumber, @Param("score")double score, @Param("keyValue")String keyValue);



}
