package com.isoftstone.dto.msg5;/*
 * @package_name com.isoftstone.dto.msg5
 * @date 2018/2/14 23:00  
 * @user Eaton
 */

/**
 * 查询明细
 */
public class QueryCom {
    //编号 查询日期 查询操作员 查询原因
    private String no;
    private String queryTime;
    private String operator;
    private String reason;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
