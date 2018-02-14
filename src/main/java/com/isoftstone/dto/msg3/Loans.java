package com.isoftstone.dto.msg3;

/**
 * 贷款
 */
public class Loans {
    private String message;//信息
    //账户状态 五级分类 本金余额 剩余还款期数 本月应还款 应还款日 本月实还款 最近一次还款日期
    private String status;//账户状态
    private String classify;//五级分类
    private String balance;//本金余额
    private String repayment;//剩余还款期数
    private String payment;//本月应还款
    private String payTime;//应还款日
    private String payment1;//本月实还款
    private String payTime1;//最近一次还款日期
    //当前逾期期数 当前逾期金额 逾期31—60天未还本金 逾期61－90天未还本金 逾期91－180天未还本金 逾期180天以上未还本金
    private String overdue;//当前逾期期数
    private String overdueMoney;//当前逾期金额
    private String overdueMoney31;//当前逾期金额
    private String overdueMoney61;//当前逾期金额
    private String overdueMoney91;//当前逾期金额
    private String overdueMoney180;//当前逾期金额

    private String record;//还款记录

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getRepayment() {
        return repayment;
    }

    public void setRepayment(String repayment) {
        this.repayment = repayment;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayment1() {
        return payment1;
    }

    public void setPayment1(String payment1) {
        this.payment1 = payment1;
    }

    public String getPayTime1() {
        return payTime1;
    }

    public void setPayTime1(String payTime1) {
        this.payTime1 = payTime1;
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }

    public String getOverdueMoney() {
        return overdueMoney;
    }

    public void setOverdueMoney(String overdueMoney) {
        this.overdueMoney = overdueMoney;
    }

    public String getOverdueMoney31() {
        return overdueMoney31;
    }

    public void setOverdueMoney31(String overdueMoney31) {
        this.overdueMoney31 = overdueMoney31;
    }

    public String getOverdueMoney61() {
        return overdueMoney61;
    }

    public void setOverdueMoney61(String overdueMoney61) {
        this.overdueMoney61 = overdueMoney61;
    }

    public String getOverdueMoney91() {
        return overdueMoney91;
    }

    public void setOverdueMoney91(String overdueMoney91) {
        this.overdueMoney91 = overdueMoney91;
    }

    public String getOverdueMoney180() {
        return overdueMoney180;
    }

    public void setOverdueMoney180(String overdueMoney180) {
        this.overdueMoney180 = overdueMoney180;
    }
}
