package com.example.demo.mapper;

import com.example.demo.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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

    @Insert("insert into student(sname,spassword) values(#{sname},##{spassword})")
    int insertStudent(Student student) ;
}