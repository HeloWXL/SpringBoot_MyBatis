package com.example.demo.controller;

import com.example.demo.controller.vo.Page;
import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    //教师注册
    @PostMapping("insertTeacher")
    public JSONObject insertTeacher(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Teacher t = new Teacher();
        t.setTpassword(password);
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

    //获取教师的Session ok
    @GetMapping("getTeacherSession")
    public JSONObject GetTeacherSession(HttpServletRequest request){
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




}
