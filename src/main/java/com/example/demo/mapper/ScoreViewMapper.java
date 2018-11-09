package com.example.demo.mapper;

import com.example.demo.model.ScoreView;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ScoreViewMapper {
    int insert(ScoreView record);

    int insertSelective(ScoreView record);



    @Select("select FLOOR(AVG(scores)),classname\n" +
            "from v\n" +
            "GROUP BY classname")
    List<Integer> getAvgScore();

    @Select("select classname\n" +
            "from v \n" +
            "GROUP BY classname")
    List<String> getClassName();


    @Select("select coursename\n" +
            "from v\n" +
            "GROUP BY coursename")
    List<String> getCourseName();



//    得到各个班级语文的平均分
    @Select("select FLOOR(AVG(scores)),classname,coursename\n" +
            "from v\n" +
            "where coursename='语文'\n" +
            "GROUP BY classname,coursename")
    List<Integer> getChineseAvgScore();

    //得到各个班级数学的平均分
    @Select("select FLOOR(AVG(scores)),classname,coursename\n" +
            "from v\n" +
            "where coursename='数学'\n" +
            "GROUP BY classname,coursename")
    List<Integer> getMathAvgScore();

    //得到各个班级英语的平均分
    @Select("select FLOOR(AVG(scores)),classname,coursename\n" +
            "from v\n" +
            "where coursename='英语'\n" +
            "GROUP BY classname,coursename")
    List<Integer> getEnglishAvgScore();

    //得到各个班级政治的平均分
    @Select("select FLOOR(AVG(scores)),classname,coursename\n" +
            "from v\n" +
            "where coursename='政治'\n" +
            "GROUP BY classname,coursename")
    List<Integer> getPolityAvgScore();



}