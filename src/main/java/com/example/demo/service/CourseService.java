package com.example.demo.service;

import com.example.demo.controller.vo.Page;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxl
 * @date 2018/10/28
 */
@Service
public class CourseService {
    @Resource
    private CourseMapper courseMapper;

    public int InsertIntoCourseByTid(Course course, Teacher teacher){
        return courseMapper.InsertIntoCourseByTid(course,teacher);
    }
    public Course selectByCid(int cid){
        return courseMapper.selectByPrimaryKey(cid);
    }


    public List<Course> getAllCourse(Page page){
        return courseMapper.getAllCourse(page);
    }
    public int deleteByCid(Integer cid){
        return courseMapper.deleteByPrimaryKey(cid);
    }
    public int getCourseCount(){
        return courseMapper.getCourseCount();
    }


    public List<Course> getCourseByTid(int tid){
        return courseMapper.getCourseByTid(tid);
    }

    public List<Course>  getCourseBySid(int sid){
        return courseMapper.getCourseBySid(sid);
    }

//     根据教师的ID查询学生信息-1
    public List<Course> getCourseOrderByTid(int tid){
        return courseMapper.getCourseByOrderByCnameTid(tid);
    }



//    获得课程列表根据评分进行排序
    public List<Course> getAllCourseList(){
        return courseMapper.getAllCourseListOrderPingfen();
    }

//    获得全部分的课程列表
    public List<Course> getAllCourse(){
        return courseMapper.getAllCourseList();
    }

//    根据课程的ID来更新评分
    public int updateCoursePingfen(int cid ,int pingfen){
        return courseMapper.updatePingfen(cid,pingfen);
    }
//    推送课程
    public List<Course> sendMessage(String cname){
        return courseMapper.pushSendMessage(cname);
    }
}
