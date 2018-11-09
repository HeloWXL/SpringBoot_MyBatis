package com.example.demo.controller;

import com.example.demo.model.Select;
import com.example.demo.service.SelectService;
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
@RequestMapping("select")
public class SelectController {

    @Resource
    private SelectService selectService;

    @PostMapping("insertselect")
    public int insertSelect(HttpServletRequest request){
        String selectname = request.getParameter("selectname");
        String question = request.getParameter("question");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d =request.getParameter("d");
        String answer = request.getParameter("answer");
        String tid = request.getParameter("tid");

        Select select = new Select();
        select.setSelectA(a);
        select.setSelectB(b);
        select.setSelectC(c);
        select.setSelectD(d);
        select.setSelectName(selectname);
        select.setSelectAnswer(answer);
        select.setTid(Integer.parseInt(tid));

        return selectService.insertSelect(select);

    }
}
