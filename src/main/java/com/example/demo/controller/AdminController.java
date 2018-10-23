package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.Student;
import com.example.demo.service.AdminService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.web.HttpMediaTypeException;
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

@RequestMapping("admin")
@RestController
public class AdminController {
    @Resource
    private AdminService adminService;
//    添加一个管理员
    @PostMapping("insertAdmin")
    public int insertAdmin(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Admin admin = new Admin();
        admin.setAdminName(name);
        admin.setAdminPassword(password);
        int i = adminService.insertAdmin(admin);
        return i;
    }
//    获得所有的管理员列表
    @GetMapping("getAllAdmin")
    public JSONArray getAllAdmin(){
        List<Admin> adminList = adminService.getAllAdmin();
        JSONArray jsonArray = JSONArray.fromObject(adminList);
        return jsonArray;
    }

//    登录检查以及获取管理员的session
    @PostMapping("checkAdmin")
    public JSONObject checkAdmin(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = new Admin();
        admin.setAdminName(name);
        admin.setAdminPassword(password);
        Admin admin1 = adminService.checkLogin(admin);
        request.getSession().setAttribute("adminsession",admin1);
        JSONObject jsonObject= JSONObject.fromObject(admin1);
        return jsonObject;
    }
//    获取管理员的session
    @GetMapping("getAdminSession")
    public JSONObject getAdminSession(HttpServletRequest request){
        String key = request.getParameter("adminBean");
        Admin admin = (Admin) request.getSession().getAttribute(key);
        JSONObject jsonObject = JSONObject.fromObject(admin);
        return jsonObject;
    }

    //根据管理员的ID删除管理员
    @RequestMapping("deleteAdminByID")
    public JSONObject deleteAdminById(HttpServletRequest request){
        String id = request.getParameter("id");
        int i = adminService.deleteAdmin(Integer.parseInt(id));
        JSONObject jsonObject = JSONObject.fromObject(i);
        return jsonObject;
    }

}
