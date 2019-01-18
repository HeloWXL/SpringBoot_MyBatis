package com.example.demo.service;

import com.example.demo.controller.vo.Page;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.model.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxl
 * @date 2018/10/19
 */
@Service
public class TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

//    教师注册 添加一名教师
    public int insertTeacher(Teacher teacher){
        return teacherMapper.insertIntoTeacher(teacher);
    }


//    显示出所有的教师
    public List<Teacher> selectAllTeacher(Page page){
        return teacherMapper.selectAllTeacher(page);
    }



    //删除教师
    public int deleteTeacher(Integer tid){
        return teacherMapper.deleteByPrimaryKey(tid);
    }



    //教师登录检查
    public Teacher checkLogin(Teacher teacher){
        return teacherMapper.checkLogin(teacher);
    }



//    更新教师信息 获取教师的ID 根据ID更新教师的信息
    public int updateTeahcer(Teacher teacher){
        return teacherMapper.updateByPrimaryKey(teacher);
    }

//    通过教师的ID查询教师
    public Teacher selectTeacherByTid(Integer tid){
        return teacherMapper.selectByPrimaryKey(tid);
    }

//    获得教师总数量
    public int getTeacherCount(){
        return teacherMapper.getTeacherCount();
    }


    public Teacher getTeahceNameBySid(int sid){
        return teacherMapper.getTeacherBySid(sid);
    }



//    根據教師的姓名獲得教師的登陸密碼
    public String getPassword(String tname){
        return teacherMapper.getPassword(tname);
    }


}
