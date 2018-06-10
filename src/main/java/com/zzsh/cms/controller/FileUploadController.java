package com.zzsh.cms.controller;

import com.zzsh.cms.commons.pojo.FileResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: cms
 * @description: 文件上传控制器
 * @author: 彭博文
 * @create: 2018-06-09 14:02
 **/
@Controller
@RequestMapping("fileUpload")
public class FileUploadController {


    @RequestMapping
    @ResponseBody
    public FileResult uploadFile(MultipartFile fileName){

        return new FileResult();
    }




}
