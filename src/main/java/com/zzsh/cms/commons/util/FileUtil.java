package com.zzsh.cms.commons.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * @program: cms
 * @description: 文件工具
 * @author: 彭博文
 * @create: 2018-06-10 15:53
 **/
public class FileUtil {

    public static String  uploadFile(MultipartFile file, String filePath) throws Exception {
        byte[] fileBytes = file.getBytes();
        String fileNoname = file.getOriginalFilename();
        String prefix = fileNoname.substring(fileNoname.lastIndexOf(".")+1);
        //生成唯一文件名
        String randomFileName = UUID.randomUUID().toString().replaceAll("-","")+"."+prefix;
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+randomFileName);
        out.write(fileBytes);
        out.flush();
        out.close();
        return randomFileName;
    }
}
