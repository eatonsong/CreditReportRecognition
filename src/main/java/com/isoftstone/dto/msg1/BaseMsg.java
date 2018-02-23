package com.isoftstone.dto.msg1;/*
 * @package_name com.isoftstone.dto
 * @date 2018/2/13 14:55  
 * @user Eaton
 * 1个人基本信息
 */

import java.io.Serializable;
import java.util.List;

public class BaseMsg implements Serializable{

    //性别 出生日期 婚姻状况 手机号码
    private String gender;
    private String birthday;
    private String maritalstate;
    private String mobile;
    //单位电话 住宅电话 学历 学位
    private String officetelePhoneNo;
    private String hometelePhoneNo;
    private String edulevel;
    private String edudegree;
    //通讯地址 户籍地址
    private String postaddress;
    private String registeredaddress;
    private Spouse spouse;//配偶
    //居住信息
    private List<Residence> residences;
    private List<Professional> professionals;

    public List<Professional> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(List<Professional> professionals) {
        this.professionals = professionals;
    }

    public List<Residence> getResidences() {
        return residences;
    }

    public void setResidences(List<Residence> residences) {
        this.residences = residences;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMaritalstate() {
        return maritalstate;
    }

    public void setMaritalstate(String maritalstate) {
        this.maritalstate = maritalstate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOfficetelePhoneNo() {
        return officetelePhoneNo;
    }

    public void setOfficetelePhoneNo(String officetelePhoneNo) {
        this.officetelePhoneNo = officetelePhoneNo;
    }

    public String getHometelePhoneNo() {
        return hometelePhoneNo;
    }

    public void setHometelePhoneNo(String hometelePhoneNo) {
        this.hometelePhoneNo = hometelePhoneNo;
    }

    public String getEdulevel() {
        return edulevel;
    }

    public void setEdulevel(String edulevel) {
        this.edulevel = edulevel;
    }

    public String getEdudegree() {
        return edudegree;
    }

    public void setEdudegree(String edudegree) {
        this.edudegree = edudegree;
    }

    public String getPostaddress() {
        return postaddress;
    }

    public void setPostaddress(String postaddress) {
        this.postaddress = postaddress;
    }

    public String getRegisteredaddress() {
        return registeredaddress;
    }

    public void setRegisteredaddress(String registeredaddress) {
        this.registeredaddress = registeredaddress;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }
}
