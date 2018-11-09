package com.example.demo.controller;



import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.util.Date;
import java.util.Random;

/**
 * @author wangxl
 * @date 2018/10/30
 */
@RequestMapping("upload")
@RestController
public class UploadImageController {

    @RequestMapping("uploadImage")
    public JSONObject SmartUpload(@RequestParam(value = "file", required = false) MultipartFile file,
                                  HttpServletRequest request) {
        File targetFile = null;
        String fileName = file.getOriginalFilename();//获取文件名加后缀
        if (fileName != null && fileName != "") {
//            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload/imgs/";//存储路径
            String path = request.getSession().getServletContext().getRealPath("./images"); //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;//新的文件名

            //先判断文件是否存在
            File file1 = new File(path + "/" + new Date());
            //如果文件夹不存在则创建
            if (!file1.exists() && !file1.isDirectory()) {
                file1.mkdir();
            }
            targetFile = new File(file1, fileName);
            try {
                file.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JSONObject jsonObject = JSONObject.fromObject("上传成功");
        return jsonObject;

    }

}
