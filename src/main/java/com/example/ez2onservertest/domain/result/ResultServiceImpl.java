package com.example.ez2onservertest.domain.result;

import com.example.ez2onservertest.domain.kakaologin.UserInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ResultServiceImpl implements ResultService {

    ResultMapper resultMapper;

    public ResultServiceImpl(ResultMapper resultMapper) {
        this.resultMapper = resultMapper;
    }

    @Override
    public int writeResult(int musicNumber, String key, float score, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserInfoDTO userid = (UserInfoDTO) session.getAttribute("userid");

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setRe_num(musicNumber);
        resultDTO.setResult_type(key);
        resultDTO.setResult_score(score);
        resultDTO.setUser_id(userid.getId());

        if (userid == null) {
            return 0;

        }

        if (Objects.isNull(resultMapper.selectResult(resultDTO))) {
            resultMapper.insertResult(resultDTO);
            return 0;
        }

       resultMapper.updateResult(resultDTO);
        return 0;
    }

    @Override
    public List<ResultDTO> getAllResult(int musicNumber, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserInfoDTO userid = (UserInfoDTO) session.getAttribute("userid");

        if (Objects.isNull(userid)) {
            // 예와발생
            try {
                throw new Exception("로그인 안된 사용자 입니다");
            } catch (Exception e)    {
                System.out.println("err_msg : " + e.getMessage());
                e.printStackTrace();
            }

        }

        String id = userid.getId();

        return resultMapper.selectAllResult(musicNumber, id);
    }


}
