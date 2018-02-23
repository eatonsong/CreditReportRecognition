package com.isoftstone.dto.msg3;

/**
 * 贷记卡
 */
public class LoancardInfo {
    private String message;//信息
    //账户状态 已用额度 最近6个月平均使用额度 最大使用额度 本月应还款
    private String loanacctState;//账户状态
    private String usedcreditlimitamount;//已用额度
    private String latest6monthusedavgamount;//最近6个月平均使用额度
    private String usedhighestamount;//最大使用额度
    private String scheduledpaymentamount;//本月应还款
    //账单日 本月实还款 最近一次还款日期 当前逾期期数 当前逾期金额
    private String scheduledpaymentdate;//账单日
    private String actualpaymentamount;//本月实还款
    private String recentpaydate;
    private String curroverduecyc;
    private String curroverdueamount;


    private String record;//还款记录

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

    public String getUsedcreditlimitamount() {
        return usedcreditlimitamount;
    }

    public void setUsedcreditlimitamount(String usedcreditlimitamount) {
        this.usedcreditlimitamount = usedcreditlimitamount;
    }

    public String getLatest6monthusedavgamount() {
        return latest6monthusedavgamount;
    }

    public void setLatest6monthusedavgamount(String latest6monthusedavgamount) {
        this.latest6monthusedavgamount = latest6monthusedavgamount;
    }

    public String getUsedhighestamount() {
        return usedhighestamount;
    }

    public void setUsedhighestamount(String usedhighestamount) {
        this.usedhighestamount = usedhighestamount;
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

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
