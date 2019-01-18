package com.example.demo.mapper;

import com.example.demo.controller.vo.Page;
import com.example.demo.model.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);


    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> selectAllTeacher(Page page);


    Teacher checkLogin(Teacher teacher);

    @Select("select count(*) from teacher")
    int getTeacherCount();

    Teacher getTeacherBySid(int sid);

    String getPassword(String teacherName);

    @Insert("insert into teacher (teacher_name , teacher_password) values(#{teacherName},#{teacherPassword})")
    int insertIntoTeacher(Teacher teacher);


}