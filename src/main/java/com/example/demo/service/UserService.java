package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @author wangxl
 * @date 2018/10/13
 */
@Service("userService")
public class UserService {

    @Resource
    private UserMapper userMapper;

//    获得所有的用户信息
    public List<User> getUserList(){
        return userMapper.getListUser();
    }
//    获得所有的学生
    public List<User> getStudentList(){
        return userMapper.getStudent();
    }
//    获得所有的老师
    public List<User> getTeacher(){
        return userMapper.getTeacher();
    }
//    添加用户 学生或者老师
    public int insertUser(User user){
        return userMapper.insert(user);
    }
//    验证用户信息
    public User checkUser(User user){
        return userMapper.checkUser(user);
    }

//    修改用户信息
    public int updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
