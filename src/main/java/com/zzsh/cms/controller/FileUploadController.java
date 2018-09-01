package com.zzsh.cms.controller;

import com.zzsh.cms.commons.pojo.FileResult;
import com.zzsh.cms.commons.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: cms
 * @description: 文件上传控制器
 * @author: 彭博文
 * @create: 2018-06-09 14:02
 **/
@Controller
@RequestMapping("admin/upload")
@PropertySource("classpath:blog_setting.properties")
public class FileUploadController {
    @Value("${img_save_path}")
    private String imgSavePath;
    @Value("${accesss_img_path}")
    private String accessImgPath;
    @RequestMapping("img")
    @ResponseBody
    public FileResult uploadFile(HttpServletRequest request,MultipartFile file) throws Exception {
        //获取上传目录的绝对路径
        String filePath = ResourceUtils.getURL("classpath:").getPath()+imgSavePath;
        String filea = FileUtil.uploadFile(file, filePath);
        //返回json
        FileResult fileResult = new FileResult();
        String [] data = new String[]{accessImgPath+filea};
        fileResult.setData(data);
        fileResult.setErrno(0);
        return fileResult;
    }
}
