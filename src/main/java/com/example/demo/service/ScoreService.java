package com.example.demo.service;

import com.example.demo.mapper.ScoreMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author wangxl
 * @date 2018/11/7
 */

@Service
public class ScoreService {
    @Resource
    private ScoreMapper scoreMapper;


    public int getScoreBySid(int sid){
        return scoreMapper.getScoreBySid(sid);
    }
}
