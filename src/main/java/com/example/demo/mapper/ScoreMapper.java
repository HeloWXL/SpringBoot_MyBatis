package com.example.demo.mapper;

import com.example.demo.model.Score;
import org.apache.ibatis.annotations.Select;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer scid);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer scid);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    @Select("select score \n" +
            "from score \n" +
            "where sid = #{sid}")
    int getScoreBySid(int sid);
}