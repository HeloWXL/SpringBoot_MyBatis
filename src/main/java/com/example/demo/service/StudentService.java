package com.example.demo.service;

import com.example.demo.controller.vo.Page;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author wangxl
 * @date 2018/10/18
 */
@Service("studentService")
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    //获取所有的学生

    public List<Student> getAllStudent(Page page){
        return studentMapper.getAlLStudent(page);
    }
    //根据学生ID查询学生
    public Student getStudentById(Integer id){
        return studentMapper.selectByPrimaryKey(id);
    }
    //添加学生
     public int insertStudent(Student student){
        return studentMapper.insertSelective(student);
     }

    //更新学生信息
    public int updateStudent(Student student){
        return studentMapper.updateByPrimaryKeySelective(student);
    }
//    根据学生的id删除学生信息
    public int deleteStudent(Integer id){
        return studentMapper.deleteByPrimaryKey(id);
    }

    //登录检查
    public Student checkLogin(Student student){
        return studentMapper.checkLogin(student);
    }

    public int getStudentCount(){
        return studentMapper.getStudentCount();
    }

    public Object getScoreAndTeacherBySid(Student student){
        return studentMapper.getScoreAndTeahcerBySid(student);
    }

//    根据教师的ID查询学生信息
    public List<Student> getStudentInfoByTid(int tid){
        return studentMapper.getStudentInfoByTid(tid);
    }

    public String getPasssword(String sname){
        return studentMapper.SelectStudentBySname(sname);
    }
}
