package com.example.demo.controller;
import com.example.demo.controller.vo.Page;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxl
 * @date 2018/10/18
 */
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //获取所有学生 ok
    @PostMapping("getStudent")
    public JSONArray getStudentList(HttpServletRequest request) {
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        Page page = new Page();
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(pageSize));

        List<Student> list = studentService.getAllStudent(page);
        Map<String ,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("count",studentService.getStudentCount());
        JSONArray array = JSONArray.fromObject(map);
        return array;
    }

    //根据学生的ID查询学生 ok
    @PostMapping("getStudentById")
    public JSONObject get(Integer stuId) {
        Student stu = studentService.getStudentById(stuId);
        JSONObject jsonObject = JSONObject.fromObject(stu);
        return jsonObject;
    }

    //学生注册  添加学生 ok
    @RequestMapping(value = "insertStudent")
    public JSONObject insertStudent(HttpServletRequest request) {
        String stuname = request.getParameter("name");
        String spassword = request.getParameter("password");
        Integer rid = 3;
        Student student = new Student();
        student.setRid(rid);
        student.setSname(stuname);
        student.setSpassword(spassword);
        int i = studentService.insertStudent(student);
        JSONObject jsonObject = JSONObject.fromObject(i);
        return jsonObject;
    }

    //更新学生信息 暂时 先 放置
    @PostMapping("updateStudent")
    public int updateStudent(HttpServletRequest request) {
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String school = request.getParameter("school");
        String spassword = request.getParameter("spassword");
        Student student = new Student();
        student.setSage(Integer.parseInt(age));
        student.setSschool(school);
        student.setSsex(sex);
        student.setSpassword(spassword);
        return studentService.updateStudent(student);
    }

    //根据学生的ID删除学生 ok
    @PostMapping("deleteStudent")
    public JSONObject deleteStudent(HttpServletRequest request) {
        String stuid = request.getParameter("stuid");
        int i =  studentService.deleteStudent(Integer.parseInt(stuid));
        JSONObject jsonObject = JSONObject.fromObject(i);
        return jsonObject;
    }

    //登录检查 ok
    @PostMapping("checkLoginStudent")
    public JSONObject checkLoginStudent(HttpServletRequest request) {
        String sname = request.getParameter("sname");
        String spassword = request.getParameter("spassword");
        Student student = new Student();
        student.setSpassword(spassword);
        student.setSname(sname);
        Student stu = studentService.checkLogin(student);

        JSONObject jsonObject = JSONObject.fromObject(stu);
        if (stu != null) {
            request.getSession().setAttribute("studentSession", stu);
            return jsonObject;
        } else {
            return null;
        }
    }

    //获取student的session
    @GetMapping("getStuSession")
    public JSONObject GetStuSession(HttpServletRequest request) {
        String key = request.getParameter("studentBean");
        Student stu = (Student) request.getSession().getAttribute(key);
        JSONObject jsonObject = JSONObject.fromObject(stu);
        return jsonObject;
    }


}
