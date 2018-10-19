package com.example.demo.service;

import com.example.demo.mapper.TeacherMapper;
import com.example.demo.model.Teacher;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public int insertTreacher(Teacher teacher){
        return teacherMapper.insert(teacher);
    }

//    显示出所有的教师
    public List<Teacher> selectAllTeacher(){
        return teacherMapper.getAlLTeacher();
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
}
