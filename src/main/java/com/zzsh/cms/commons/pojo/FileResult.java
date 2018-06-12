package com.zzsh.cms.commons.pojo;

/**
 * @program: cms
 * @description: 上传文件返回对象
 * @author: 彭博文
 * @create: 2018-06-09 14:03
 **/
public class FileResult {
    /*错误码 0为成功，非0为异常*/
    private Integer errno;
    /*存放图片访问地址数组*/
    private String[] data;

    public String[] getData() {
        return data;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
