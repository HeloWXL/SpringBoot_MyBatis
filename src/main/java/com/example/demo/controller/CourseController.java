package com.example.demo.controller;

import com.example.demo.controller.vo.Page;
import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import com.example.demo.service.CourseService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    public JSONObject insertCourseByTid(HttpServletRequest request) {
        String cname = request.getParameter("cname");
        String cpicture = request.getParameter("cpic");
        String cintroduce = request.getParameter("cintroduce");
        String cvideo = request.getParameter("cvideo");

        Teacher teacher = (Teacher) request.getSession().getAttribute("teacherSession");
        Course course = new Course();
        course.setCourseName(cname);
        course.setCoursePicture(cpicture);
        course.setCourseIntroduce(cintroduce);
        course.setCourseVideo(cvideo);
        int i = courseService.InsertIntoCourseByTid(course, teacher);
        JSONObject jsonObject = JSONObject.fromObject(i);
        return jsonObject;
    }

//    获得所有的课程  列表
    @PostMapping("getAllCourseLists")
    public  Map<String,Object> getAllCourseList(HttpServletRequest request){
        String pageNo= request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        Page page = new Page();
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(pageSize));

        List<Course> courseList = courseService.getAllCourse(page);
        Map<String,Object> map = new HashMap<>();
        map.put("list",courseList);
        map.put("count",courseService.getCourseCount());

        return map;
    }
//    通过教师的id查询课程
    @PostMapping("getCourseByTid")
    public List<Course> getCourseByTid(HttpServletRequest request){
        String tid = request.getParameter("tid");
        List<Course>  courseList= courseService.getCourseByTid(Integer.parseInt(tid));
        return courseList;
    }

    @GetMapping("getAllCourseList")
    public List<Course> getAllCourseList(){
        return courseService.getAllCourseList();
    }

    @GetMapping("getAllCourse")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }


    @PostMapping("selectByCid")
    public Boolean selectByCid(HttpServletRequest request){
        String cid =request.getParameter("cid");
        Course course= courseService.selectByCid(Integer.parseInt(cid));
        request.getSession().setAttribute("cvideoSession",course.getCourseVideo());
        if(StringUtils.isNotEmpty(course.getCourseVideo())){
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("getcvideoSession")
    public Map<String,String> GetCvideo(HttpServletRequest request){
        String key = request.getParameter("getcvideo");
        String cvideo = (String) request.getSession().getAttribute(key);
        Map<String,String> map = new HashMap<>();
        map.put("cvideo",cvideo);
        return map;
    }


    @GetMapping("updateCoursePingfen")
    public Boolean UpdateCoursePingfen(HttpServletRequest request){
        String cid = request.getParameter("cid");
        String pingfen = request.getParameter("pingfen");
        int i = courseService.updateCoursePingfen(Integer.parseInt(cid),Integer.parseInt(pingfen));
        if(i==1){
            return true;
        }else{
            return false;
        }
    }


    @PostMapping("pushMessage")
    public List<Course> pushSendMessage(HttpServletRequest request){
        String c = request.getParameter("cname");
        return courseService.sendMessage(c);
    }

}

