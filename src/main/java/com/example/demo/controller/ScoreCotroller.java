package com.example.demo.controller;

import com.example.demo.service.ScoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @date 2018/11/7
 */
@RestController
@RequestMapping("score")
public class ScoreCotroller {
    @Resource
    private ScoreService scoreService;

}
