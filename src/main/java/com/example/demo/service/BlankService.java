package com.example.demo.service;

import com.example.demo.mapper.BlankMapper;
import com.example.demo.model.Blank;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @date 2018/11/9
 */
@Service
public class BlankService {

    @Resource
    private BlankMapper blankMapper;

    public int insertBlank(Blank blank){
        return blankMapper.insert(blank);
    }
}
