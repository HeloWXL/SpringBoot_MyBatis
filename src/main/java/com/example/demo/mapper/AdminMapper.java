package com.example.demo.mapper;

import com.example.demo.model.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    @Select("select * from admin where aname = #{aname} and apassword = #{apassword}")
    Admin checkAdminLogin(Admin admin);

}