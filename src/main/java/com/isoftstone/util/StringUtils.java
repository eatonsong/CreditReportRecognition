package com.isoftstone.util;/*
 * @package_name com.isoftstone.util
 * @date 2018/3/6 14:40  
 * @user Eaton
 */

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

public class StringUtils {
    /***
     *    删除base中的str
     * @author Eaton
     * @date 2018/3/14 9:49
     * @param [base, str]  
     * @return java.lang.String  
     */  
    public static String substrBystr(String base,String str){
        return base.substring(base.indexOf(str)+str.length());
    }
    /***  
     *    
     *   判断str是否没有内容
     * @author Eaton  
     * @date 2018/3/14 9:50
     * @param [str]  
     * @return boolean  
     */  
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
    /***  
     *    截取string数组中i到j下标内容
     * @author Eaton
     * @date 2018/3/14 9:50  
     * @param [arr, i, j]  
     * @return java.lang.String  
     */  
    public static String addArrayByIndex(String []arr,int i,int j){
        String str = "";
        try{
            for (int k = i; k < j+1; k++) {
                str += arr[k];
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return str;
    }
    /***
     *   判断表格是否格式混乱（是否是竖排字符）
     * @author Eaton  
     * @date 2018/3/14 11:02  
     * @param [ss]  
     * @return boolean  
     */  
    public static boolean isChaos(String ss[]){
        boolean is = false;
        int flag = 0;
        for (int i = 0; i < ss.length; i++) {
            if(ss[i].replaceAll(" ","").length()>1){
                break;
            }
            flag++;
        }
        if(flag>3){
            is = true;
        }
        return is;
    }
    /***  
     *    
     *   合并数组中长度较短的字符串至字符串之前下标
     * @author Eaton  
     * @date 2018/3/14 14:31
     * @param [ss, no]  
     * @return java.lang.String[]  
     */  
    public static String[] addToArrayIndexFront(String []ss,int no){
        for (int j = 0; j < ss.length-no; j++) {
            int minLength = ss[0].length();
            int minIndex = 0;
            for (int i = 0; i <ss.length ; i++) {
                if(ss[i].length()<minLength){
                    minLength = ss[i].length();
                    minIndex = i;
                }
            }
            if(minIndex>0){
                ss[minIndex-1] = ss[minIndex-1] + ss[minIndex];
                ss = ArrayUtils.remove(ss,minIndex);
            }
        }
        return ss;
    }
}
