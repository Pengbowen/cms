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
    @Value("${file.windows.uploadfolder}")
    private String  windowsSavePath;

    @Value("${file.linux.uploadfolder}")
    private String  linuxSavePath;

    @Value("${file.imgpath}")
    private String  imgPath;

    @Value("${accesss_path}")
    private String accessPath;
    @RequestMapping("img")
    @ResponseBody
    public FileResult uploadFile(HttpServletRequest request,MultipartFile file) throws Exception {
        //获取上传目录的绝对路径
        String filea = FileUtil.uploadFile(file, windowsSavePath+imgPath);
        //返回json
        FileResult fileResult = new FileResult();
        String [] data = new String[]{accessPath+imgPath+filea};
        fileResult.setData(data);
        fileResult.setErrno(0);
        return fileResult;
    }
}
