package com.example.demo.controller;

import com.example.demo.model.ScoreView;
import com.example.demo.service.ScoreViewService;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxl
 * @date 2018/11/3
 */
@RestController
@RequestMapping("scoreview")
public class ScoreViewController {

    @Resource
    private ScoreViewService scoreViewService;

    @GetMapping("getAvgScore")
    public JSONArray getAvgScore(){
        List<Integer> scoreList  = scoreViewService.getAvgScore();
        List<String> classNameList = scoreViewService.getClassName();
        List<String> courseList = scoreViewService.getCourseName();

        Map<String,Object> map = new HashMap<>();
        map.put("avgscore",scoreList);
        map.put("classname",classNameList);
        map.put("courselist",courseList);

        JSONArray jsonArray = JSONArray.fromObject(map);
        return jsonArray;
    }


    @GetMapping("getEveryClassScore")
    public JSONArray getEveryClassScore(){

        List<Integer> chinese = scoreViewService.getChineseScore();
        List<Integer> math = scoreViewService.getMathScore();
        List<Integer> english = scoreViewService.getEnglishScore();
        List<Integer> polity = scoreViewService.getPolityScore();
        Map<String,Object> map = new HashMap<>();

        map.put("chinese",chinese);
        map.put("math",math);
        map.put("english",english);
        map.put("polity",polity);

        JSONArray jsonArray = JSONArray.fromObject(map);
        return jsonArray;
    }


}
