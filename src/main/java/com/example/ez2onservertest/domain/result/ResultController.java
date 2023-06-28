package com.example.ez2onservertest.domain.result;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResultController {

    ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/result")
    public String result() {
        return "resultTable";

    }

    @PostMapping("/result")
    public String result(int musicNumber, String key, float score, HttpServletRequest request) {

        resultService.writeResult(musicNumber, key, score, request);

        return "main";
    }
}
