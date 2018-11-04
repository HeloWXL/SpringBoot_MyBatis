package com.example.demo.controller;

import com.example.demo.controller.vo.Page;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.service.CourseService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxl
 * @date 2018/10/28
 */
@RestController
@RequestMapping("course")
public class CourseController {
    @Resource
    private CourseService courseService;
//    老师添加一门课程
    @PostMapping("insertCouseByTid")
    public JSONObject insertCourseByTid(HttpServletRequest request){
        String cname = request.getParameter("cname");
        String cpicture = request.getParameter("cpic");
        String cintroduce = request.getParameter("cintroduce");
        String cvideo = request.getParameter("cvideo");

        Teacher teacher = (Teacher) request.getSession().getAttribute("teacherSession");
        Course course = new Course();
        course.setCname(cname);
        course.setCpicture(cpicture);
        course.setCintroduce(cintroduce);
        course.setCvideo(cvideo);
        int i = courseService.InsertIntoCourseByTid(course,teacher);
        JSONObject jsonObject = JSONObject.fromObject(i);
        return jsonObject;

    }
//    删除一门课程By课程ID
    @PostMapping("deleteCourseByCid")
    public JSONObject deleteCourseByCid(HttpServletRequest request){
        String cid = request.getParameter("cid");
        JSONObject jsonObject = JSONObject.fromObject(courseService.deleteByCid(Integer.parseInt(cid)));
        return jsonObject;
    }
//    获得所有的课程  列表
    @PostMapping("getAllCourseList")
    public JSONObject getAllCourseList(HttpServletRequest request){
        String pageNo= request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        Page page = new Page();
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(pageSize));

        List<Course> courseList = courseService.getAllCourse(page);
        Map<String,Object> map = new HashMap<>();
        map.put("list",courseList);
        map.put("count",courseService.getCourseCount());
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject;
    }
//    通过教师的id查询课程
    @PostMapping("getCourseByTid")
    public JSONArray getCourseByTid(HttpServletRequest request){
        String tid = request.getParameter("tid");
        Teacher teacher = new Teacher();
        teacher.setTid(Integer.parseInt(tid));
        JSONArray jsonArray = JSONArray.fromObject(courseService.getCourseByTid(teacher));
        return jsonArray;
    }
}

