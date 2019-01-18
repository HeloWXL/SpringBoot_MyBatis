package com.example.demo.mapper;

import com.example.demo.model.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);


    Admin checkAdminLogin(String adminName);

    @Insert("insert into admin (admin_name,admin_password) values (#{adminName},#{adminPassword})")
    int insertAdmin(Admin admin);

//    <!--查询所有的管理员-->
    List<Admin> selectAllAdmin();

}