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

//    老师添加一门课程
    @Insert("insert into course (cname,cpicture,cintroduce,cvideo,tid) values(" +
            "#{cname},#{cpicture},#{cintroduce},#{cvideo},#{tid})")
    int InsertIntoCourseByTid(Course course, Teacher teacher);


//    分页显示---课程列表
    @Select("select * from course limit #{pageNo},#{pageSize}")
    List<Course> getAllCourse(Page page);

    @Select("select count(*) from course")
    int getCourseCount();


    @Select("select c.cname,c.cpicture\n" +
            "from score sc , teacher t ,student s,course c\n" +
            "where sc.cid=c.cid and t.tid = c.tid and s.sid=sc.sid and s.sid=#{sid}")
    Course getCourseBySid(int sid);



    @Select("select * \n" +
            "from course c ,teacher t\n" +
            "where c.tid = t.tid and t.tid = #{tid}")
    List<Course> getCourseByTid(int tid);


//       根据教师的ID查询学生信息-2
    @Select("select c.cname\n" +
            "from course c ,teacher t ,student s ,score sc\n" +
            "where c.tid = t.tid and c.cid = sc.cid and s.sid = sc.sid and t.tid = #{tid}\n" +
            "order by c.cname")
    List<Course> getCourseByOrderByCnameTid(int tid);

//    按照评分进行排序
    @Select("select * from course order by cpingfen")
    List<Course> getAllCourseListOrderPingfen();

//    查询所有的课程--得到课程列表
    @Select("select * from course")
    List<Course> getAllCourseList();



}
