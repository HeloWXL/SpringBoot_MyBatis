package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wangxl
 * @date 2018/10/13
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;


    //获取所有用户 已做好
    @RequestMapping("/getUser")
    @ResponseBody
    public JSONArray getUserList() {
        List<User> list = userService.getUserList();
        JSONArray array = JSONArray.fromObject(list);
        return array;
    }

    //修改用户信息 没做好
    @RequestMapping("/update")
    public int updateUser(HttpServletRequest request){
        String u_id = request.getParameter("u_id");
        String password = request.getParameter("password");
        User u = new User();
        u.setPassword(password);
        u.setuId(Integer.getInteger(u_id));
        int ret = userService.updateUser(u);
        return  ret;
    }
    //添加User 已做好
    @RequestMapping("/insertUser")
    @ResponseBody
    public int insertUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role_id = request.getParameter("role_id");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRoleId(Integer.parseInt(role_id));
        int ret = userService.insertUser(user);
        return ret;
    }

    //    登录验证 并且保存用户对象 已做好
    @RequestMapping("/login")
    @ResponseBody
    public JSONObject showIndex(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userService.checkUser(user);
        request.getSession().setAttribute("userSession",user1);
        JSONObject jsonObject = JSONObject.fromObject(user1);
        return jsonObject;

    }
    //    获得所有的学生集合 已做好
    @RequestMapping("/getStudent")
    @ResponseBody
    public JSONArray getStudent() {
        List<User> userslist = userService.getStudentList();
        JSONArray jsonArray = JSONArray.fromObject(userslist);
        return jsonArray;
    }
    //    获得所有的教师集合 已做好
    @RequestMapping("/getTeacher")
    @ResponseBody
    public JSONArray getTeacher() {
        List<User> userslist = userService.getTeacher();
        JSONArray jsonArray = JSONArray.fromObject(userslist);
        return jsonArray;
    }

//    获取用户对象 学生或者老师 已做好
    @RequestMapping("/getUserSession")
    @ResponseBody
    public  JSONObject getUserSession(HttpServletRequest request){
        String key = request.getParameter("userBean");
        User user = (User) request.getSession().getAttribute(key);
        JSONObject jsonObject = JSONObject.fromObject(user);
        return jsonObject;
    }
//    验证管理员登录
    @RequestMapping("/backlogin")
    @ResponseBody
    public JSONObject checkAdmin(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User  u = userService.checkUser(user);
        request.getSession().setAttribute("adminSession",u);
        JSONObject jsonObject = JSONObject.fromObject(u);
        return jsonObject;
    }


}
