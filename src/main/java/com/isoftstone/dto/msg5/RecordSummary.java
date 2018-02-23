package com.isoftstone.dto.msg5;/*
 * @package_name com.isoftstone.dto.msg5
 * @date 2018/2/14 22:55  
 * @user Eaton
 */

import java.io.Serializable;
import java.util.List;

/**
 * 查询记录
 */
public class RecordSummary  implements Serializable {

    private static final long serialVersionUID = -8012218628786649932L;
    // 贷款审批 信用卡审批 (最近1个月内的查询机构数)
   // 贷款审批 信用卡审批 本人查询 (最近1个月内的查询次数)
   // 贷后管理 担保资格审查 特约商户实名审查 (最近2年内的查询次数)
    private String orgsum1;
    private String orgsum2;
    private String recordsum1;
    private String recordsum2;
    private String recordsumself;
    private String towyearrecordsum1;
    private String towyearrecordsum2;
    private String towyearrecordsum3;
    //详细信息
    private List<RecordDetail> company;
    private List<RecordDetail> person;

    public List<RecordDetail> getCompany() {
        return company;
    }

    public void setCompany(List<RecordDetail> company) {
        this.company = company;
    }

    public List<RecordDetail> getPerson() {
        return person;
    }

    public void setPerson(List<RecordDetail> person) {
        this.person = person;
    }

    public String getOrgsum1() {
        return orgsum1;
    }

    public void setOrgsum1(String orgsum1) {
        this.orgsum1 = orgsum1;
    }

    public String getOrgsum2() {
        return orgsum2;
    }

    public void setOrgsum2(String orgsum2) {
        this.orgsum2 = orgsum2;
    }

    public String getRecordsum1() {
        return recordsum1;
    }

    public void setRecordsum1(String recordsum1) {
        this.recordsum1 = recordsum1;
    }

    public String getRecordsum2() {
        return recordsum2;
    }

    public void setRecordsum2(String recordsum2) {
        this.recordsum2 = recordsum2;
    }

    public String getRecordsumself() {
        return recordsumself;
    }

    public void setRecordsumself(String recordsumself) {
        this.recordsumself = recordsumself;
    }

    public String getTowyearrecordsum1() {
        return towyearrecordsum1;
    }

    public void setTowyearrecordsum1(String towyearrecordsum1) {
        this.towyearrecordsum1 = towyearrecordsum1;
    }

    public String getTowyearrecordsum2() {
        return towyearrecordsum2;
    }

    public void setTowyearrecordsum2(String towyearrecordsum2) {
        this.towyearrecordsum2 = towyearrecordsum2;
    }

    public String getTowyearrecordsum3() {
        return towyearrecordsum3;
    }

    public void setTowyearrecordsum3(String towyearrecordsum3) {
        this.towyearrecordsum3 = towyearrecordsum3;
    }
}
