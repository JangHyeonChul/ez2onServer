package com.example.ez2onservertest.domain.btnlevel;

import java.util.List;

/*
* getBtnLevel : 악곡 번호에 해당하는 난이도를 List에 담아 List 출력한다
*
* */

public interface BtnLevelService {

    List<List<String>> getBtnLevel(int musicNumber);
}
