package com.example.demo.mapper;

import com.example.demo.controller.vo.Page;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    @Select("select * from course where tid = #{tid}")
    List<Course> getCourseByTid(Teacher teacher);

//    老师添加一门课程
    @Insert("insert into course (cname,cpicture,cintroduce,cvideo,tid) values(" +
            "#{cname},#{cpicture},#{cintroduce},#{cvideo},#{tid})")
    int InsertIntoCourseByTid(Course course, Teacher teacher);


//    分页显示---课程列表
    @Select("select * from course limit #{pageNo},#{pageSize}")
    List<Course> getAllCourse(Page page);

    @Select("select count(*) from course")
    int getCourseCount();



}
