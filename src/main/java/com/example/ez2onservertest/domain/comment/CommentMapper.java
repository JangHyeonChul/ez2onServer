package com.example.ez2onservertest.domain.comment;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper {

    int insertComment(Map<String, String> commentMap);
    List<CommentDTO> selectComments(int musicNumber);
}
