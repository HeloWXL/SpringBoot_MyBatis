package com.example.demo.mapper;

import com.example.demo.controller.vo.Page;
import com.example.demo.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);


    //获得所有的学生分页
    List<Student> getAlLStudent(Page page);

    //    得到学生的数量
    @Select("select count(*) from student")
    int getStudentCount();



//    --------------------------------------------------



//    根据学生的姓名进行查询
    Student checkLogin(String name);

    @Insert("insert into student(student_name,student_password) values(#{studentName},#{studentPassword})")
    int insertStudent(Student student) ;






    @Select("select score \n" +
            "from score \n" +
            "where sid =#{sid}")
    String getScoreAndTeahcerBySid(Student student);

    //    根据教师ID查询学生的信息
    @Select("select s.sname,s.profession,s.sschool,s.ssex\n" +
            "from course c ,teacher t ,student s ,score sc\n" +
            "where c.tid = t.tid and c.cid = sc.cid and s.sid = sc.sid and t.tid = #{tid} order by c.cname")
    List<Student> getStudentInfoByTid(int tid);

}