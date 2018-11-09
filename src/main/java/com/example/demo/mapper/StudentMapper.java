package com.example.demo.mapper;

import com.example.demo.controller.vo.Page;
import com.example.demo.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    @Select("select * from student limit #{pageNo},#{pageSize}")
    List<Student> getAlLStudent(Page page);

    @Select("select * from student where sname =#{sname}")
    Student checkLogin(Student stu);

    @Insert("insert into student(sname,spassword) values(#{sname},##{spassword})")
    int insertStudent(Student student) ;

    @Select("select count(*) from student")
    int getStudentCount();

    @Select("select score \n" +
            "from score \n" +
            "where sid =#{sid}")
    String getScoreAndTeahcerBySid(Student student);

//    根据教师ID查询学生的信息
    @Select("select s.sname,s.profession,s.sschool,s.ssex\n" +
            "from course c ,teacher t ,student s ,score sc\n" +
            "where c.tid = t.tid and c.cid = sc.cid and s.sid = sc.sid and t.tid = #{tid} order by c.cname")
    List<Student> getStudentInfoByTid(int tid);

//    根据姓名查询---密码
    @Select("select spassword from student where sname = #{sname}")
    String SelectStudentBySname(String sname);




}