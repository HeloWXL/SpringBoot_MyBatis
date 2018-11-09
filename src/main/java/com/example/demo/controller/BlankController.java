package com.example.demo.controller;

import com.example.demo.model.Blank;
import com.example.demo.service.BlankService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wangxl
 * @date 2018/11/9
 */
@RestController
@RequestMapping("blank")
public class BlankController {

    @Resource
    private BlankService blankService;

    @PostMapping("inserBlank")
    public int insertBlank(HttpServletRequest request){
        String blankquestion = request.getParameter("blankquestion");
        String blankanswer = request.getParameter("blankanswer");
        String tid = request.getParameter("tid");
        Blank blank = new Blank();
        blank.setBlankAnswer(blankanswer);
        blank.setBlankName("不知道哈哈哈");
        blank.setBlankQuestion(blankquestion);
        blank.setTid(Integer.parseInt(tid));
        return blankService.insertBlank(blank);
    }
}
