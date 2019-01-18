package com.example.demo.mapper;

import com.example.demo.controller.vo.Page;
import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    //    分页显示---课程列表
    List<Course> getAllCourse(Page page);


    @Select("select count(*) from course")
    int getCourseCount();


    //    老师添加一门课程 ok
    @Insert("insert into course (course_name,course_picture,course_introduce,course_video,tid) values(" +
            "#{courseName},#{course_picture},#{course_introduce},#{course_video},#{teacher_id})")
    int InsertIntoCourseByTid(Course course, Teacher teacher);

//    根据学生的ID查询课程
    List<Course> getCourseBySid(int sid);
//    根据教师的ID所教授的课程
    List<Course> getCourseByTid(int tid);


//    -------------------------------------------

//           根据教师的ID查询学生信息-2
    @Select("select c.course_name\n" +
            "from course c ,teacher t ,student s ,score sc\n" +
            "where c.tid = t.tid and c.cid = sc.cid and s.sid = sc.sid and t.tid = #{tid}\n" +
            "order by c.cname")
    List<Course> getCourseByOrderByCnameTid(int tid);

    //    按照评分进行排序
    List<Course> getAllCourseListOrderPingfen();

    //    查询所有的课程--得到课程列表
    @Select("select * from course")
    List<Course> getAllCourseList();

//    根据课程的ID更新的课程的评分 ok
    @Update("update course set course_pingfen = #{pingfen} where cid = #{cid}")
    int updatePingfen(@Param("cid") int cid , @Param("pingfen") int pingfen);

//    推送课程信息
    @Select("select * from course where cname like  \"%#{cname}%\" order by cpingfen")
    List<Course>   pushSendMessage(String cname);
}