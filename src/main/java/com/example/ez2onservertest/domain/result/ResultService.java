package com.example.ez2onservertest.domain.result;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResultService {

    int writeResult(int musicNumber, String key, float score, HttpServletRequest request);

    List<ResultDTO> getAllResult(int musicNumber, HttpServletRequest request);



}
