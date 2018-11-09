package com.example.demo.mapper;

import com.example.demo.model.Blank;

public interface BlankMapper {
    int deleteByPrimaryKey(Integer blankId);

    int insert(Blank record);

    int insertSelective(Blank record);

    Blank selectByPrimaryKey(Integer blankId);

    int updateByPrimaryKeySelective(Blank record);

    int updateByPrimaryKey(Blank record);
}