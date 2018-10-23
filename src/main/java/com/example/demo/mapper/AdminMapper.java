package com.example.demo.mapper;

import com.example.demo.model.Admin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    @Select("select * from admin")
    List<Admin> getAlLAdmin();

    @Select("select * from admin where admin_name =#{adminName} and admin_password =#{adminPassword}")
    Admin checkLogin(Admin admin);
}