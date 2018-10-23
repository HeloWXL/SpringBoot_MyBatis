package com.example.demo.service;

import com.example.demo.mapper.CourseMapper;
import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxl
 * @date 2018/10/20
 */
@Service
public class CourseService {

    @Resource
    private CourseMapper courseMapper;

//    获取课程列表
    public List<Course> getAllCourse(){
        return courseMapper.getAllCourse();
    }

    //根据课程的Id删除课程
    public int deleteCourseById(Integer id){
        return courseMapper.deleteByPrimaryKey(id);
    }

//    根据教师的Id得到教师所教授的课程列表
    public List<Course> getCourseByTno(Teacher teacher){
        return courseMapper.getCourseByTno(teacher);
    }
}
