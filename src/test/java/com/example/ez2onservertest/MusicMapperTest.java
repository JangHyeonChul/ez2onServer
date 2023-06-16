package com.example.ez2onservertest;


import com.example.ez2onservertest.global.musicDB.MusicDTO;
import com.example.ez2onservertest.global.musicDB.MusicMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MusicMapperTest {

    @Autowired
    MusicMapper music;

    @Test
    void selectAllMusics() {
        List<MusicDTO> result = music.selectAllMusics();

        Assertions.assertThat(result)
                .isNotEmpty()
                .isNotNull();
    }

    @Test
    void selectMusic() {
        MusicDTO result = music.selectMusic(1);

        Assertions.assertThat(result)
                .isNotNull();

    }
}
