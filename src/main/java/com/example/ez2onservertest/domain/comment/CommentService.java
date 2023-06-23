package com.example.ez2onservertest.domain.comment;

import java.util.List;
import java.util.Map;

public interface CommentService {

    int writeComment(Map<String, String> commentMap);
    List<CommentDTO> getComments(int musicNumber, int offset);
    int getCountComments(int musicNumber);
    int getCommentLevels(int musicNumber);

    List<CommentDTO> insertCommentDTOCount(List<CommentDTO> commentDTO, int number);
    void updateLevels(Map<String, String> commentMap);
    double getScoreTally(int musicNumber);
}
