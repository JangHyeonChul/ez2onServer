package com.example.ez2onservertest.domain.comment;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService{

    CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public int writeComment(Map<String, String> commentMap) {
        return commentMapper.insertComment(commentMap);
    }

    @Override
    public List<CommentDTO> getComments(int musicNumber) {
        return commentMapper.selectComments(musicNumber);
    }
}
