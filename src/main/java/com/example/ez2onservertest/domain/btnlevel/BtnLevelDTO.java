package com.example.ez2onservertest.domain.btnlevel;

import lombok.Data;

/*
* re_num에 해당하는 악곡들의 데이터를 받아온다
* btn_4K : 4버튼에 해당하는 레벨
* btn_5K : 5버튼에 해당하는 레벨
* btn_6K : 6버튼에 해당하는 레벨
* btn_8K : 8버튼에 해당하는 레벨
*  */

@Data
public class BtnLevelDTO {

    private int re_num;
    private String btn_4K;
    private String btn_5K;
    private String btn_6K;
    private String btn_8K;

    public BtnLevelDTO() {}

}
