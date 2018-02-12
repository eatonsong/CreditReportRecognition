package com.isoftstone.util;/*
 * @package_name com.isoftstone.util
 * @date 2018/2/12 16:34  
 * @user Eaton
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealStrSub {
    /**
     * 正则表达式匹配两个指定字符串中间的内容
     * @param soap
     * @return
     */
    public static List<String> getSubUtil(String soap,String rgex){
        List<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        return list;
    }

    /**
     * 返回单个字符串，若匹配到多个的话就返回第一个，方法与getSubUtil一样
     * @param soap
     * @param rgex
     * @return
     */
    public static String getSubUtilSimple(String soap,String rgex){
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while(m.find()){
            return m.group(1);
        }
        return "";
    }
    /**
     * 截取字符串string中特定字符str1、str2之间的字符串
     * @param string
     * @param str1
     * @param str2
     * @return 截取之后的字符串result（不包含str1和str2,只取中间的字符串）
     */
    public static String subString(String string, String str1, String str2){
        //记录特定字符str1、str2索引
        int beginIndex = string.indexOf(str1);
        int endIndex = string.indexOf(str2);
        //索引<0，表示字符串中不存在字符，return
        if(beginIndex < 0){
            return "[" + string + "]" + " 中不存在 " + str1 + "，无法截取";
        } else if(endIndex < 0){
            return "[" + string + "]" + " 中不存在 " + str2 + "，无法截取";
        }
        //参数str1 str2位置可调换，不管str1 str2在字符串中的位置顺序如何，都能截取它们之间的字符串
        if(beginIndex > endIndex){
            int tempIndex = beginIndex;
            beginIndex = endIndex;
            endIndex = tempIndex;
            String tempStr = str1;
            str1 = str2;
            str2 = tempStr;
        }
        //截取 第一个substring()方法包含边界字符str1或str2,为了使截取结果不包含边界，用第二个substring()方法去掉边界字符
        String result = string.substring(beginIndex, endIndex).substring(str1.length());
        return result;
    }
    /***  
     *    
     *   
     * @author Eaton  
     * @date 2018/2/12 17:30  
     * @param [string, str1, str2]
     * @return java.lang.String  
     */  
    public static String deleteMiddleString(String string, String str1, String str2){
        int beginIndex = string.indexOf(str1);
        if(beginIndex!=-1){
            String str3 =  string.substring(beginIndex);
        }
        return string;
    }
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        String str = "abc3443abcfgjhgabcgfjabc";
        String rgex = "abc(.*?)abc";
        System.out.println(getSubUtil(str,rgex));
        System.out.println(getSubUtilSimple(str, rgex));
    }
}
