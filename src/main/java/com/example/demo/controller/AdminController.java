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

/**
 * @author wangxl
 * @date 2018/11/4
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping("checkAdmin")
    public Boolean checkAdminLogin(HttpServletRequest request){
        String aname = request.getParameter("username");
        String apassword = request.getParameter("password");

        if(Md5Utils.getSaltverifyMD5(apassword,adminService.getPassword(aname))){
            Admin admin = new Admin();
            admin.setAname(aname);
            Admin admin1 = adminService.checkAdminLogin(admin);
            request.getSession().setAttribute("adminsession", admin1);
            return true;
        }else{
            return false;
        }
    }


    @PostMapping("getAdminSession")
    public Admin getAdminSession(HttpServletRequest request){
        String key = request.getParameter("adminBean");
        Admin admin = (Admin) request.getSession().getAttribute(key);
        return admin;
    }


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


    @PostMapping("insertAdmin")
    public int insertAdmin(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String strmd5 = Md5Utils.getSaltMD5(password);
        Admin admin = new Admin();
        admin.setAname(name);
        admin.setApassword(strmd5);
        return adminService.insertAdmin(admin);
    }
}
