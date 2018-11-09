package com.example.demo.mapper;

import com.example.demo.model.Select;

public interface SelectMapper {
    int deleteByPrimaryKey(Integer selectId);

    int insert(Select record);

    int insertSelective(Select record);

    Select selectByPrimaryKey(Integer selectId);

    int updateByPrimaryKeySelective(Select record);

    int updateByPrimaryKey(Select record);
}