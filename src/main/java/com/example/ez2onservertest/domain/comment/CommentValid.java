package com.example.ez2onservertest.domain.comment;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * File Name : CommentValid
 * Description : 댓글 작성 유효성 검사 수행
 * Update : 2023-08-10
 */


@Component
@Slf4j
public class CommentValid {

    private static final String ERROR_MESSAGE = "올바르지 않은 값입니다";


    /*
    * 댓글 유효성 검사 로직 수행
    * 아래 해당 유효성 검사 통과 실패시 Map안에 Error 메세지 내용을 담아 반환
    * 통과 성공 시 Map안에 아무것도 담기지 않으며 이는 통과 성공을 의미
    *
    * 1. 평가 점수에 정수를 제외한 다른 데이터가 들어올 경우
    * 2. 코멘트 내용이 비어있을 경우
    * 3. 코멘트의 내용이 Null 일경우
    * 4. 평가점수가 비어있을 경우
    * 5. 평가점수가 Null 일경우
    *
    * */

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
