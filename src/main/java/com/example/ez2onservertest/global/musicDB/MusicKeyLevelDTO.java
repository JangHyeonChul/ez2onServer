package com.example.ez2onservertest.global.musicDB;

import lombok.Data;

@Data
public class MusicKeyLevelDTO {

    private int re_num;
    private float level_4K;
    private float level_5K;
    private float level_6K;
    private float level_8K;

    public MusicKeyLevelDTO() {}

}
