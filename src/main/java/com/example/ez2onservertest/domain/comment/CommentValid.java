package com.example.ez2onservertest.domain.comment;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class CommentValid {

    private static final String ERROR_MESSAGE = "올바르지 않은 값입니다";

    public Map<String, String> commentValid(Map<String, String> commentMap, HttpServletRequest request) {
        Map<String, String> commentErrorMap = new HashMap<>();

        log.info("[요청 IP : {}] 코멘트 등록 정보 {}", request.getRemoteAddr(), commentMap);


        try {
            Integer.parseInt(commentMap.get("musicnumber"));
            Integer.parseInt(commentMap.get("level"));
        } catch (NumberFormatException e) {
            commentErrorMap.put("errorMessage", ERROR_MESSAGE);

            log.warn("[요청 IP : {}] 코멘트 등록 실패 NumberFormat 형식이 잘못 되었습니다", request.getRemoteAddr());
            return commentErrorMap;

        }

        if (commentMap.get("content").equals("")) {
            commentErrorMap.put("errorMessage", ERROR_MESSAGE);

            log.warn("[요청 IP : {}] 코멘트 등록 실패 내용이 비어있습니다", request.getRemoteAddr(), commentMap);

        }

        if (commentMap.get("content") == null) {
            commentErrorMap.put("errorMessage", ERROR_MESSAGE);

            log.warn("[요청 IP : {}] 코멘트 등록 실패 내용이 비어있습니다", request.getRemoteAddr(), commentMap);
        }

        if (commentMap.get("level").equals("")) {
            commentErrorMap.put("errorMessage", ERROR_MESSAGE);

            log.warn("[요청 IP : {}] 코멘트 등록 평가 레벨이 비어있습니다", request.getRemoteAddr(), commentMap);
        }

        if (commentMap.get("level") == null) {
            commentErrorMap.put("errorMessage", ERROR_MESSAGE);

            log.warn("[요청 IP : {}] 코멘트 등록 평가 레벨이 비어있습니다", request.getRemoteAddr(), commentMap);
        }

        return commentErrorMap;

    }


}
