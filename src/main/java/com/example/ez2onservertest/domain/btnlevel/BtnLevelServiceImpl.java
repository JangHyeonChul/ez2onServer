package com.example.ez2onservertest.domain.btnlevel;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BtnLevelServiceImpl implements BtnLevelService {

    BtnLevelMapper btnLevelMapper;

    public BtnLevelServiceImpl(BtnLevelMapper btnLevelMapper) {
        this.btnLevelMapper = btnLevelMapper;
    }


    /*
    * DB에 저장되어있는 난이도 (ex : 4/5/6/8)를 /로 split하여 List형태로 담아서 반환
    * */

    @Override
    public List<List<String>> getBtnLevel(int musicNumber) {
        BtnLevelDTO btnLevel = btnLevelMapper.selectBtnLevel(musicNumber);

        List<String> btn4K = Arrays.stream(btnLevel.getBtn_4K().split("/"))
                .collect(Collectors.toList());

        List<String> btn5K = Arrays.stream(btnLevel.getBtn_5K().split("/"))
                .collect(Collectors.toList());

        List<String> btn6K = Arrays.stream(btnLevel.getBtn_6K().split("/"))
                .collect(Collectors.toList());

        List<String> btn8K = Arrays.stream(btnLevel.getBtn_8K().split("/"))
                .collect(Collectors.toList());

        return Arrays.asList(btn4K, btn5K, btn6K, btn8K);

    }
}
