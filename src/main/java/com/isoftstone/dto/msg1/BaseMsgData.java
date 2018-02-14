package com.isoftstone.dto.msg1;/*
 * @package_name com.isoftstone.dto
 * @date 2018/2/13 14:59  
 * @user Eaton
 * 数据发生机构名称
 */

import com.isoftstone.dto.msg1.HouseData;
import com.isoftstone.dto.msg1.WorkData;

import java.util.List;

public class BaseMsgData {
    //性别 出生日期 婚姻状况 手机号码
    private String sex;
    private String birth;
    private String merry;
    private String telphone;
    //单位电话 住宅电话 学历 学位
    private String phone1;
    private String phone2;
    private String school;
    private String degree;
    //通讯地址 户籍地址
    private String telAddress;
    private String regAddress;
    //配偶
    private String wife;
    private List<HouseData> houseDatas;
    private List<WorkData> workDatas;

    public List<WorkData> getWorkDatas() {
        return workDatas;
    }

    public void setWorkDatas(List<WorkData> workDatas) {
        this.workDatas = workDatas;
    }

    public List<HouseData> getHouseDatas() {
        return houseDatas;
    }

    public void setHouseDatas(List<HouseData> houseDatas) {
        this.houseDatas = houseDatas;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMerry() {
        return merry;
    }

    public void setMerry(String merry) {
        this.merry = merry;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getTelAddress() {
        return telAddress;
    }

    public void setTelAddress(String telAddress) {
        this.telAddress = telAddress;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }
}
