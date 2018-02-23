package com.isoftstone.dto;/*
 * @package_name com.isoftstone.dto
 * @date 2018/2/12 15:01  
 * @user Eaton
 */


import com.isoftstone.dto.msg1.BaseMsg;
import com.isoftstone.dto.msg1.BaseMsgData;
import com.isoftstone.dto.msg2.SumMsg;
import com.isoftstone.dto.msg3.CreditMsg;
import com.isoftstone.dto.msg4.CommonMsg;
import com.isoftstone.dto.msg5.RecordSummary;

public class Messages  {
    private String reportNo;//报告编号
    private String queryTime;//查询请求时间
    private String reportCreateTime;//报告时间

    private String name;//被查询者姓名
    private String certType;//被查询者证件类型
    private String certNo;//被查询者证件号码
    private String userCode;//操作员
    private String queryReason;//查询原因
    private BaseMsg baseMsg;//个人基本信息
    private BaseMsgData baseMsgData;//数据发生机构
    private SumMsg sumMsg;//信息概要
    private CreditMsg creditMsg;//信贷交易信息明细
    private CommonMsg commonMsg;//四 公共信息明细
    private RecordSummary recordSummary;//查询记录

    public RecordSummary getRecordSummary() {
        return recordSummary;
    }

    public void setRecordSummary(RecordSummary recordSummary) {
        this.recordSummary = recordSummary;
    }

    public CommonMsg getCommonMsg() {
        return commonMsg;
    }

    public void setCommonMsg(CommonMsg commonMsg) {
        this.commonMsg = commonMsg;
    }

    public CreditMsg getCreditMsg() {
        return creditMsg;
    }

    public void setCreditMsg(CreditMsg creditMsg) {
        this.creditMsg = creditMsg;
    }

    public SumMsg getSumMsg() {
        return sumMsg;
    }

    public void setSumMsg(SumMsg sumMsg) {
        this.sumMsg = sumMsg;
    }

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

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getQueryReason() {
        return queryReason;
    }

    public void setQueryReason(String queryReason) {
        this.queryReason = queryReason;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }

    public String getReportCreateTime() {
        return reportCreateTime;
    }

    public void setReportCreateTime(String reportCreateTime) {
        this.reportCreateTime = reportCreateTime;
    }
}
