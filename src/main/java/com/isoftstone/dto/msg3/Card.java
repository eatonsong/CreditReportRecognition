package com.isoftstone.dto.msg3;

/**
 * 贷记卡
 */
public class Card {
    private String message;//信息
    //账户状态 已用额度 最近6个月平均使用额度 最大使用额度 本月应还款
    private String status;//账户状态
    private String used;//已用额度
    private String used6;//最近6个月平均使用额度
    private String usedMax6;//最近6个月平均使用额度
    private String usedMax;//最大使用额度
    private String thisMonth;//本月应还款
    //账单日 本月实还款 最近一次还款日期 当前逾期期数 当前逾期金额
    private String payTime;//账单日
    private String payMonth;//本月实还款
    private String payLast;
    private String overdueNum;
    private String overdue;
    private String record;//还款记录

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getUsed6() {
        return used6;
    }

    public void setUsed6(String used6) {
        this.used6 = used6;
    }

    public String getUsedMax6() {
        return usedMax6;
    }

    public void setUsedMax6(String usedMax6) {
        this.usedMax6 = usedMax6;
    }

    public String getUsedMax() {
        return usedMax;
    }

    public void setUsedMax(String usedMax) {
        this.usedMax = usedMax;
    }

    public String getThisMonth() {
        return thisMonth;
    }

    public void setThisMonth(String thisMonth) {
        this.thisMonth = thisMonth;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayMonth() {
        return payMonth;
    }

    public void setPayMonth(String payMonth) {
        this.payMonth = payMonth;
    }

    public String getPayLast() {
        return payLast;
    }

    public void setPayLast(String payLast) {
        this.payLast = payLast;
    }

    public String getOverdueNum() {
        return overdueNum;
    }

    public void setOverdueNum(String overdueNum) {
        this.overdueNum = overdueNum;
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
