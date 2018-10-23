package com.example.demo.service;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxl
 * @date 2018/10/18
 */
@Service
public class AdminService {
    @Resource
    private AdminMapper adminMapper;

//    添加一个管理员 注册
    public int insertAdmin(Admin admin){
        return adminMapper.insert(admin);
    }

//    管理员登录检查
    public Admin checkLogin(Admin admin){
        return adminMapper.checkLogin(admin);
    }

    //删除一个管理员
    public int deleteAdmin(Integer id){
        return adminMapper.deleteByPrimaryKey(id);
    }

    //获得管理员列表
    public List<Admin> getAllAdmin(){
        return adminMapper.getAlLAdmin();
    }

}
