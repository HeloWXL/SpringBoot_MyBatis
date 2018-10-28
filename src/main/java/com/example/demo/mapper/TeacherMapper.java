package com.example.demo.mapper;

import com.example.demo.model.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    @Select("select * from teacher")
    List<Teacher> getAlLTeacher();

    @Select("select * from teacher where tname =#{tname} and tpassword =#{tpassword}")
    Teacher checkLogin(Teacher teacher);
}