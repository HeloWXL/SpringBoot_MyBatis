package com.example.demo.controller;

import com.example.demo.Utils.Md5Utils;
import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author wangxl
 * @date 2018/11/4
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    @Resource
    private AdminService adminService;


//    管理员登录 ok
    @PostMapping("checkAdmin")
    public Boolean checkAdminLogin(HttpServletRequest request){
        String aname = request.getParameter("username");
        String apassword = request.getParameter("password");

        if(Md5Utils.getSaltverifyMD5(apassword,adminService.checkAdminLogin(aname).getAdminPassword())){
            Admin admin1 = adminService.checkAdminLogin(aname);
            request.getSession().setAttribute("adminsession", admin1);
            return true;
        }else{
            return false;
        }
    }

//    获得管理员的session
    @PostMapping("getAdminSession")
    public Admin getAdminSession(HttpServletRequest request){
        String key = request.getParameter("adminBean");
        Admin admin = (Admin) request.getSession().getAttribute(key);
        return admin;
    }

//    退出登录
    @GetMapping("loginOut")
    public int removeSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        session.removeAttribute("adminsession");
        if(session==null){
            System.out.println("session已清除");
            return 1;

        }else{
            System.out.println("session未清除");
            return 0;
        }
    }

//    管理员注册 ok
    @PostMapping("insertAdmin")
    public int insertAdmin(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String strmd5 = Md5Utils.getSaltMD5(password);
        Admin admin = new Admin();
        admin.setAdminName(name);
        admin.setAdminPassword(strmd5);
        return adminService.insertAdmin(admin);
    }

    @GetMapping("getAllAdmin")
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }
}
