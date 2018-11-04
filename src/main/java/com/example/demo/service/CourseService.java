package com.example.demo.service;

import com.example.demo.controller.vo.Page;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public List<Course> getAllCourse(Page page){
        return courseMapper.getAllCourse(page);
    }
    public int deleteByCid(Integer cid){
        return courseMapper.deleteByPrimaryKey(cid);
    }
    public List<Course> getCourseByTid(Teacher teacher){
        return  courseMapper.getCourseByTid(teacher);
    }
    public int getCourseCount(){
        return courseMapper.getCourseCount();
    }

}
