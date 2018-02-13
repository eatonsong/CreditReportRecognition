package com.isoftstone.dto;/*
 * @package_name com.isoftstone.dto
 * @date 2018/2/12 15:01  
 * @user Eaton
 */


public class Messages {
    private String reportNo;//报告编号
    private String requestTime;//查询请求时间
    private String reportTime;//报告时间

    private String name;//被查询者姓名
    private String idtype;//被查询者证件类型
    private String idcard;//被查询者证件号码
    private String operator;//操作员
    private String reason;//查询原因
    private BaseMsg baseMsg;//个人基本信息
    private BaseMsgData baseMsgData;//数据发生机构

    public BaseMsg getBaseMsg() {
        return baseMsg;
    }

    public void setBaseMsg(BaseMsg baseMsg) {
        this.baseMsg = baseMsg;
    }

    public BaseMsgData getBaseMsgData() {
        return baseMsgData;
    }

    public void setBaseMsgData(BaseMsgData baseMsgData) {
        this.baseMsgData = baseMsgData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
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

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }
}
