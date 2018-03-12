package com.isoftstone.util;/*
 * @package_name com.isoftstone.util
 * @date 2018/3/6 14:40  
 * @user Eaton
 */

public class StringUtils {
    public static String substrBystr(String base,String str){
        return base.substring(base.indexOf(str)+str.length());
    }
    public static boolean isNotEmpty(String str){
        boolean a = true;
        try {
            if(str==null||"".equals(str)||"".equals(str.replaceAll(" ",""))){
                a = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            a = false;
        }
        return a;
    }
}
