package com.example.ez2onservertest.domain.comment;

import lombok.Data;

/**
 * File Name : CommentDTO
 * Description : 댓글 작성을 위한 DTO
 * Update : 2023-08-10
 */


/*
* 댓글에 정보에 대한 DTO
* int co_num : 코멘트 번호
* int re_num : 악곡 번호
* String co_content : 코멘트 내용
* int co_level : 사용자가 입력한 평가점수
* String co_btn : 평가점수에 해당하는 버튼
*
* int comment_cnt 댓글 총수 (페이지 네이션 계산)
* */

@Data
public class CommentDTO {

    private int co_num;
    private int re_num;
    private String co_content;
    private int co_level;
    private String co_btn;

    private int comment_cnt;

    CommentDTO() {}
}
