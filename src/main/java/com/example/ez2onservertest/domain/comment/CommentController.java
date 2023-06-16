package com.example.ez2onservertest.domain.comment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class CommentController {

    @PostMapping("/comment")
    @ResponseBody
    public void comment(@RequestBody Map<String, String> commentMap) {
        System.out.println("commentJSON = " + commentMap);
    }

}
