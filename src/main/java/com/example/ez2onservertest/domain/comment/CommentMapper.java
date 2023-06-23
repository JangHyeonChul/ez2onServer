package com.example.ez2onservertest.domain.comment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
