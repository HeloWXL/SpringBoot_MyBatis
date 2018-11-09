package com.example.demo.controller;

import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxl
 * @date 2018/11/4
 */
@RequestMapping("common")
@RestController
public class CommonController {
    @Resource
    private CourseService courseService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private StudentService studentService;

//    得到用户的总人数，课程总数和新增人数
    @GetMapping("getCount")
    public Map<String,Integer> getCount(){
        int stu = studentService.getStudentCount();
        int teacher = teacherService.getTeacherCount();
        int course = courseService.getCourseCount();
        Map<String ,Integer> map = new HashMap<>();
        map.put("upcount",12);
        map.put("usercount",teacher+stu);
        map.put("coursecount",course);
        return map;
    }

}
