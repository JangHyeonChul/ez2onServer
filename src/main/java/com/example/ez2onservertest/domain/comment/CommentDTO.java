package com.example.ez2onservertest.domain.comment;

import lombok.Data;

@Data
public class CommentDTO {

    private int co_num;
    private int re_num;
    private String co_content;
    private int co_level;

    CommentDTO() {}
}
