package com.example.demo.mapper;

import com.example.demo.model.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    @Select("select * from admin where aname = #{aname}")
    Admin checkAdminLogin(Admin admin);

    @Select("select apassword from admin where aname = #{aname}")
    String getPassword(String aname);

    @Insert("insert into admin (aname,apassword) values (#{aname},#{apassword})")
    int insertAdmin(Admin admin);

}