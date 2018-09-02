package com.zzsh.cms.commons.util;

/**
 * @program: cms
 * @description: 判断运行系统是linux还是windows
 * @author: 彭博文
 * @create: 2018-09-02 21:17
 **/
public class OsUtil {

    /**
     * 判断系统是否运行在windows系统
     * @return
     */
    public static boolean onWindows() {
        String osName = System.getProperties().getProperty("os.name").toLowerCase();

        if (osName.contains("windows")) {
           return true;
        } else {
           return false;
        }
    }
}
