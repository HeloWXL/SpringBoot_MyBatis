package com.example.demo.controller;

import com.example.demo.Utils.Md5Utils;
import com.example.demo.controller.vo.Page;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxl
 * @date 2018/10/18
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @Resource
    private StudentService studentService;

    @Resource
    private CourseService courseService;

    //教师注册
    @PostMapping("insertTeacher")
    public JSONObject insertTeacher(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String strmd5 = Md5Utils.getSaltMD5(password);

        Teacher t = new Teacher();
        t.setTpassword(strmd5);
        t.setTname(name);
        t.setRid(3);

        int i = teacherService.insertTreacher(t);
        JSONObject jsonObject = JSONObject.fromObject(i);
        return jsonObject;
    }

    //获取所有的教师 ok
    @PostMapping("getAllTeacher")
    public JSONObject selectAllTeacher(HttpServletRequest request){
        String pageNo= request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        Page page = new Page();
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(pageSize));

        List<Teacher> teachers = teacherService.selectAllTeacher(page);
        Map<String,Object> map = new HashMap<>();
        map.put("list",teachers);
        map.put("count",teacherService.getTeacherCount());
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject;
    }

    //根据教师的ID删除教师 ok
    @PostMapping("deleteTeahcer")
    public JSONObject deleteTeacher(HttpServletRequest request){
        String id = request.getParameter("id");
        int i = teacherService.deleteTeacher(Integer.parseInt(id));
        JSONObject jsonObject =JSONObject.fromObject(i);
        return jsonObject;
    }

    //登录检查 ok
    @PostMapping("checkLoginTeacher")
    public Boolean checkLoginTeacher(HttpServletRequest request){
        String name = request.getParameter("name");
        String password =request.getParameter("password");

        if(Md5Utils.getSaltverifyMD5(password,teacherService.getPassword(name))){
           Teacher teacher = new Teacher();
           teacher.setTname(name);
            Teacher teacher1 = teacherService.checkLogin(teacher);
            request.getSession().setAttribute("teacherSession", teacher1);
            return true;
        }else{
            return false;
        }

    }

    //获取教师的Session ok
    @PostMapping("getTeacherSession")
    public JSONObject getTeacherSession(HttpServletRequest request){
        String key = request.getParameter("teacherBean");
        Teacher teacher = (Teacher) request.getSession().getAttribute(key);
        JSONObject jsonObject = JSONObject.fromObject(teacher);
        return jsonObject;
    }

//    根据教师的ID查询教师信息 ok
    @PostMapping("selectTeacherByTid")
    public JSONObject getTeacherByTid(HttpServletRequest request){
        String tid = request.getParameter("tid");
        JSONObject jsonObject = JSONObject.fromObject(teacherService.selectTeacherByTid(Integer.parseInt(tid)));
        return jsonObject;
    }

//    通过教师的ID查询学习课程的学生信息
    @PostMapping("getStudentAndCourse")
    public Map<String,Object> getStudentAndCourse(HttpServletRequest request){
        String tid = request.getParameter("tid");
        List<Student> students =  studentService.getStudentInfoByTid(Integer.parseInt(tid));
        List<Course> courses = courseService.getCourseOrderByTid(Integer.parseInt(tid));
        Map<String,Object> map = new HashMap<>();
        map.put("student",students);
        map.put("course",courses);
        return map;
    }




}
