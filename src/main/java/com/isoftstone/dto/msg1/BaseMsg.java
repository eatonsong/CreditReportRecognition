package com.isoftstone.dto.msg1;/*
 * @package_name com.isoftstone.dto
 * @date 2018/2/13 14:55  
 * @user Eaton
 * 1个人基本信息
 */

import com.isoftstone.dto.msg1.House;
import com.isoftstone.dto.msg1.Work;

import java.io.Serializable;
import java.util.List;

public class BaseMsg implements Serializable{

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
    //姓名 证件类型 证件号码 工作单位 联系电话 配偶
    private String name1;
    private String idtype1;
    private String idcard1;
    private String work1;
    private String telphone1;

    //居住信息
    private List<House> houses;
    private List<Work> works;

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
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


    public String getTelphone1() {
        return telphone1;
    }

    public void setTelphone1(String telphone1) {
        this.telphone1 = telphone1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getIdtype1() {
        return idtype1;
    }

    public void setIdtype1(String idtype1) {
        this.idtype1 = idtype1;
    }

    public String getIdcard1() {
        return idcard1;
    }

    public void setIdcard1(String idcard1) {
        this.idcard1 = idcard1;
    }

    public String getWork1() {
        return work1;
    }

    public void setWork1(String word1) {
        this.work1 = word1;
    }
}
