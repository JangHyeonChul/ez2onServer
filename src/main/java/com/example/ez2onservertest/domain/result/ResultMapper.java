package com.example.ez2onservertest.domain.result;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ResultMapper {

    int insertResult(ResultDTO resultDTO);
    ResultDTO selectResult(ResultDTO resultDTO);

    List<ResultDTO> selectAllResult(@Param("musicnumber")int musicNumber,
                                    @Param("userid") String userid);

    int updateResult(ResultDTO resultDTO);
}
