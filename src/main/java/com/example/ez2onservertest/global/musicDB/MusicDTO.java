package com.example.ez2onservertest.global.musicDB;

import lombok.Data;

@Data
public class MusicDTO {

    private int re_num;
    private String re_name;
    private String re_genre;
    private String re_bpm;
    private String re_author;
    private String re_category;
    private float re_level;
    private String re_sumnail;
    private String re_info;
    private String re_video;

    // JOIN
    private int ca_num;
    private String ca_name;


    public MusicDTO(){}

}
