package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import com.example.demo.service.CourseService;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wangxl
 * @date 2018/10/18
 */
@RestController
@RequestMapping("course")
public class CourseController {


    @Resource
    private CourseService courseService;
//    基本的增删改查


//    获得所有的课程列表
    @RequestMapping("getAllCourese")
    public JSONArray getAllCourse(){
        JSONArray jsonArray = JSONArray.fromObject(courseService.getAllCourse());
        return jsonArray;
    }

//    根据教师ID查询课程列表
    @PostMapping("getCourseByTno")
    public JSONArray getCourseByTno(HttpServletRequest request){
        String tno = request.getParameter("tno");
        Teacher t = new Teacher();
        t.setTid(Integer.parseInt(tno));
        List<Course> courseList = courseService.getCourseByTno(t);
        JSONArray js = JSONArray.fromObject(courseList);
        return js;
    }


    

}
