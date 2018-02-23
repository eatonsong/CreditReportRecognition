package com.isoftstone.dto.msg4;/*
 * @package_name com.isoftstone.dto.msg4
 * @date 2018/2/14 20:57  
 * @user Eaton
 */

import java.io.Serializable;

public class AccfundRecord  implements Serializable {
    private static final long serialVersionUID = -6643883479458712945L;
    //编号 参缴地 参缴日期 初缴月份 缴至月份 缴费状态 月缴存额 个人缴存比例 单位缴存比例
    private String no;
    private String area;
    private String registerdate;
    private String firstmonth;
    private String tomonth;
    private String state;
    private String pay;
    private String ownpercent;
    private String compercent;


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    public String getFirstmonth() {
        return firstmonth;
    }

    public void setFirstmonth(String firstmonth) {
        this.firstmonth = firstmonth;
    }

    public String getTomonth() {
        return tomonth;
    }

    public void setTomonth(String tomonth) {
        this.tomonth = tomonth;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getOwnpercent() {
        return ownpercent;
    }

    public void setOwnpercent(String ownpercent) {
        this.ownpercent = ownpercent;
    }

    public String getCompercent() {
        return compercent;
    }

    public void setCompercent(String compercent) {
        this.compercent = compercent;
    }
}
