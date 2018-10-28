package com.example.demo.mapper;

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


//    获取课程列表 按照评分降序排序
    @Select("select * from course  order by cpingfen desc")
    List<Course> getAllCourse();


    @Select("select * from course where tid = #{tid}")
    List<Course> getCourseByTid(Teacher teacher);


//    学生添加一门课程
//    @Insert("insert into course (tid) values(tid=(select tid  from score sc , student s where sc.sid = " +
////            "s.sid and s.sid=#{sid}))")
////    public int InsertStudentBySid(Student stu);

//    老师添加一门课程
    @Insert("insert into course (cname,cpicture,cintroduce,cvideo,tid) values(" +
            "#{cname},#{cpicture},#{cintroduce},#{cvideo},#{tid})")
    public int InsertIntoCourseByTid(Course course, Teacher teacher);



}
