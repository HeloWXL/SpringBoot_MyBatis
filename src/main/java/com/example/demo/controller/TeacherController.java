package com.example.demo.controller;

import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;
import javafx.beans.binding.ObjectExpression;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.validator.constraints.EAN;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;


    //教师注册
    @PostMapping("insertTeacher")
    public JSONObject insertTeacher(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Teacher t = new Teacher();
        t.setTpassword(password);
        t.setTname(name);

        int i = teacherService.insertTreacher(t);
        JSONObject jsonObject = JSONObject.fromObject(i);
        return jsonObject;
    }

    //获取所有的教师
    @GetMapping("getAllTeacher")
    public JSONArray selectAllTeacher(){
        List<Teacher> teachers = teacherService.selectAllTeacher();
        JSONArray jsonArray = JSONArray.fromObject(teachers);
        return jsonArray;
    }

    //根据教师的ID删除教师
    @PostMapping("deleteTeahcer")
    public JSONObject deleteTeacher(HttpServletRequest request){
        String id = request.getParameter("id");
        int i = teacherService.deleteTeacher(Integer.parseInt(id));
        JSONObject jsonObject =JSONObject.fromObject(i);
        return jsonObject;
    }

    //登录检查
    @PostMapping("checkLoginTeacher")
    public JSONObject checkLoginTeacher(HttpServletRequest request){
        String name = request.getParameter("name");
        String password =request.getParameter("password");

        Teacher t = new Teacher();
        t.setTname(name);
        t.setTpassword(password);

        Teacher teacher = teacherService.checkLogin(t);

        if(teacher!=null){
            request.getSession().setAttribute("teacherSession",teacher);
            JSONObject jsonObject =JSONObject.fromObject(teacher);
            return jsonObject;
        }else{
            return null;
        }
    }

    //获取教师的Session
    @GetMapping("getTeacherSession")
    public JSONObject GetTeacherSession(HttpServletRequest request){
        String key = request.getParameter("teacherBean");
        Teacher teacher = (Teacher) request.getSession().getAttribute(key);
        JSONObject jsonObject = JSONObject.fromObject(teacher);
        return jsonObject;
    }

}
