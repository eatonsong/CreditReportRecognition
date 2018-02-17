package com.isoftstone.dto.msg4;/*
 * @package_name com.isoftstone.dto.msg4
 * @date 2018/2/14 20:57  
 * @user Eaton
 */

public class PayRecord {
    //编号 参缴地 参缴日期 初缴月份 缴至月份 缴费状态 月缴存额 个人缴存比例 单位缴存比例
    private String no;
    private String place;
    private String date1;
    private String date2;
    private String date3;
    private String status;
    private String payMonth;
    private String personScale;
    private String comScale;


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getDate3() {
        return date3;
    }

    public void setDate3(String date3) {
        this.date3 = date3;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayMonth() {
        return payMonth;
    }

    public void setPayMonth(String payMonth) {
        this.payMonth = payMonth;
    }

    public String getPersonScale() {
        return personScale;
    }

    public void setPersonScale(String personScale) {
        this.personScale = personScale;
    }

    public String getComScale() {
        return comScale;
    }

    public void setComScale(String comScale) {
        this.comScale = comScale;
    }


}
