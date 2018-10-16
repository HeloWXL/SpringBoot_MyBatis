package com.example.demo.mapper;



import com.example.demo.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


//    获得所有的用户信息
    @Select("select * from user")
    List<User> getListUser();

//    验证用户信息登录
    User checkUser(User user);


//    获得所有的学生
    @Select("select * from user where role_id = 2")
    List<User> getStudent();


//    获得所有的老师
    @Select("select * from user where role_id = 3")
    List<User> getTeacher();


//    获得所有的管理员
    @Select("select * from user where role_id = 1")
    List<User> getAdmin();

}