package com.example.demo.mapper;

import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    @Select("select * from course")
    List<Course> getAllCourse();

    @Select("select * from course where tid= #{tid}")
    List<Course> getCourseByTno(Teacher teacher);
}