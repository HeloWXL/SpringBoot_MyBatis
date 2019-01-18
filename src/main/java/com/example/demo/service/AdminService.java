package com.example.demo.service;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxl
 * @date 2018/11/4
 */
@Service
public class AdminService {
    @Resource
    private AdminMapper adminMapper;

//    管理员登录
    public Admin checkAdminLogin(String adminName){
        return adminMapper.checkAdminLogin(adminName);
    }

    public int insertAdmin(Admin admin){
        return adminMapper.insertAdmin(admin);
    }

    public List<Admin> getAllAdmin(){
        return adminMapper.selectAllAdmin();
    }
}
