package com.example.ez2onservertest.domain.comment;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommentValid {

    private static final String ERROR_MESSAGE = "올바르지 않은 값입니다";

    public Map<String, String> commentValid(Map<String, String> commentMap) {
        Map<String, String> commentErrorMap = new HashMap<>();

        try {
            Integer.parseInt(commentMap.get("musicnumber"));
            Integer.parseInt(commentMap.get("level"));
        } catch (NumberFormatException e) {
            commentErrorMap.put("errorMessage", ERROR_MESSAGE);
            return commentErrorMap;
        }

        if (commentMap.get("content").equals("")) {
            commentErrorMap.put("errorMessage", ERROR_MESSAGE);
        }

        if (commentMap.get("content") == null) {
            commentErrorMap.put("errorMessage", ERROR_MESSAGE);
        }

        if (commentMap.get("level").equals("")) {
            commentErrorMap.put("errorMessage", ERROR_MESSAGE);
        }

        if (commentMap.get("level") == null) {
            commentErrorMap.put("errorMessage", ERROR_MESSAGE);
        }

        return commentErrorMap;

    }


}
