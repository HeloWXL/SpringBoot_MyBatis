package com.example.demo.mapper;

import com.example.demo.controller.vo.Page;
import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);


    @Select("select * from teacher limit #{pageNo},#{pageSize}")
    List<Teacher> getAlLTeacher(Page page);

    @Select("select * from teacher where tname =#{tname}")
    Teacher checkLogin(Teacher teacher);


    @Select("select count(*) from teacher")
    int getTeacherCount();

    @Select("select t.tname\n" +
            "from score sc , teacher t ,student s,course c\n" +
            "where sc.cid=c.cid and t.tid = c.tid and s.sid=sc.sid and s.sid=#{sid}")
    Teacher getTeacherBySid(int sid);

    @Select("select tpassword from teacher where tname = #{tname}")
    String getPassword(String tname);
}