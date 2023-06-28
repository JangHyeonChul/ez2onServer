package com.example.ez2onservertest.domain.result;

import lombok.Data;

@Data
public class ResultDTO {

    private int re_num;
    private String user_id;
    private String result_type;
    private float result_score;

    public ResultDTO() {}

    @Data
    public class userKeyResult {
        private float level_4K;
        private float level_5K;
        private float level_6K;
        private float level_8K;

        public userKeyResult() {}
    }



}
