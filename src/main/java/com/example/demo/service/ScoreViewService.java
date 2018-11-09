package com.example.demo.service;

import com.example.demo.mapper.ScoreViewMapper;
import com.example.demo.model.ScoreView;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxl
 * @date 2018/11/3
 */
@Service
public class ScoreViewService {

    @Resource
    private ScoreViewMapper scoreViewMapper;

    //获取学生的平均成绩-----用于成绩的统计分析
    public List<Integer> getAvgScore(){
        return scoreViewMapper.getAvgScore();
    }

    //得到班级列表
    public List<String> getClassName(){
        return scoreViewMapper.getClassName();
    }

    //得到课程的列表
    public List<String> getCourseName(){
        return scoreViewMapper.getCourseName();
    }


//    得到各个班级的语文成绩
    public List<Integer> getChineseScore(){
        return scoreViewMapper.getChineseAvgScore();
    }


//    得到各个班级的数学成绩
    public List<Integer> getMathScore(){
        return scoreViewMapper.getMathAvgScore();
    }

//    得到各个班级的英语成绩
    public List<Integer> getEnglishScore(){
        return scoreViewMapper.getEnglishAvgScore();
    }

//    得到各个班级的政治成绩
    public List<Integer> getPolityScore(){
        return scoreViewMapper.getPolityAvgScore();
    }





}
