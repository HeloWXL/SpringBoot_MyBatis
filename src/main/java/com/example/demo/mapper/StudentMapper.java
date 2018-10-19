package com.example.demo.mapper;

import com.example.demo.model.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    @Select("select * from student")
    List<Student> getAlLStudent();

    @Select("select * from student where sname =#{sname} and spassword =#{spassword}")
    Student checkLogin(Student stu);
}