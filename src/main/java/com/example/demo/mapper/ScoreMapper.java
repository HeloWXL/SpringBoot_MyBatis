package com.example.demo.mapper;

import com.example.demo.model.Score;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer scId);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer scId);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}