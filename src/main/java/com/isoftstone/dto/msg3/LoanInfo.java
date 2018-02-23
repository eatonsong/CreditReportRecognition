package com.isoftstone.dto.msg3;

import java.io.Serializable;

/**
 * 贷款
 */
public class LoanInfo  implements Serializable {
    private static final long serialVersionUID = 8106619325633628093L;
    private String message;//信息
    //账户状态 五级分类 本金余额 剩余还款期数 本月应还款 应还款日 本月实还款 最近一次还款日期
    private String loanacctState;//账户状态
    private String class5State;//五级分类
    private String balance;//本金余额
    private String remainpaymentcyc;//剩余还款期数
    private String scheduledpaymentamount;//本月应还款
    private String scheduledpaymentdate;//应还款日
    private String actualpaymentamount;//本月实还款
    private String recentpaydate;//最近一次还款日期
    //当前逾期期数 当前逾期金额 逾期31—60天未还本金 逾期61－90天未还本金 逾期91－180天未还本金 逾期180天以上未还本金
    private String curroverduecyc;//当前逾期期数
    private String curroverdueamount;//当前逾期金额
    private String overdue31to60amount;//当前逾期金额
    private String overdue61to90amount;//当前逾期金额
    private String overdue91to180amount;//当前逾期金额
    private String overdueover180amount;//当前逾期金额

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

    public String getLoanacctState() {
        return loanacctState;
    }

    public void setLoanacctState(String loanacctState) {
        this.loanacctState = loanacctState;
    }

    public String getClass5State() {
        return class5State;
    }

    public void setClass5State(String class5State) {
        this.class5State = class5State;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getRemainpaymentcyc() {
        return remainpaymentcyc;
    }

    public void setRemainpaymentcyc(String remainpaymentcyc) {
        this.remainpaymentcyc = remainpaymentcyc;
    }

    public String getScheduledpaymentamount() {
        return scheduledpaymentamount;
    }

    public void setScheduledpaymentamount(String scheduledpaymentamount) {
        this.scheduledpaymentamount = scheduledpaymentamount;
    }

    public String getScheduledpaymentdate() {
        return scheduledpaymentdate;
    }

    public void setScheduledpaymentdate(String scheduledpaymentdate) {
        this.scheduledpaymentdate = scheduledpaymentdate;
    }

    public String getActualpaymentamount() {
        return actualpaymentamount;
    }

    public void setActualpaymentamount(String actualpaymentamount) {
        this.actualpaymentamount = actualpaymentamount;
    }

    public String getRecentpaydate() {
        return recentpaydate;
    }

    public void setRecentpaydate(String recentpaydate) {
        this.recentpaydate = recentpaydate;
    }

    public String getCurroverduecyc() {
        return curroverduecyc;
    }

    public void setCurroverduecyc(String curroverduecyc) {
        this.curroverduecyc = curroverduecyc;
    }

    public String getCurroverdueamount() {
        return curroverdueamount;
    }

    public void setCurroverdueamount(String curroverdueamount) {
        this.curroverdueamount = curroverdueamount;
    }

    public String getOverdue31to60amount() {
        return overdue31to60amount;
    }

    public void setOverdue31to60amount(String overdue31to60amount) {
        this.overdue31to60amount = overdue31to60amount;
    }

    public String getOverdue61to90amount() {
        return overdue61to90amount;
    }

    public void setOverdue61to90amount(String overdue61to90amount) {
        this.overdue61to90amount = overdue61to90amount;
    }

    public String getOverdue91to180amount() {
        return overdue91to180amount;
    }

    public void setOverdue91to180amount(String overdue91to180amount) {
        this.overdue91to180amount = overdue91to180amount;
    }

    public String getOverdueover180amount() {
        return overdueover180amount;
    }

    public void setOverdueover180amount(String overdueover180amount) {
        this.overdueover180amount = overdueover180amount;
    }
}
