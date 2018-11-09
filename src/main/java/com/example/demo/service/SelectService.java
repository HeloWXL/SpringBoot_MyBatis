package com.example.demo.service;

import com.example.demo.mapper.SelectMapper;
import com.example.demo.model.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @date 2018/11/9
 */
@Service
public class SelectService {
    @Resource
    private SelectMapper selectMapper;


    public int insertSelect(Select select){
        return selectMapper.insert(select);
    }
}
