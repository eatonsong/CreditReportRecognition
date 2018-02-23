package com.isoftstone.dto.msg5;/*
 * @package_name com.isoftstone.dto.msg5
 * @date 2018/2/14 23:00  
 * @user Eaton
 */

import java.io.Serializable;

/**
 * 查询明细
 */
public class RecordDetail  implements Serializable {
    private static final long serialVersionUID = 2991797714672196469L;
    //编号 查询日期 查询操作员 查询原因
    private String no;
    private String queryDate;
    private String querier;
    private String queryReason;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(String queryDate) {
        this.queryDate = queryDate;
    }

    public String getQuerier() {
        return querier;
    }

    public void setQuerier(String querier) {
        this.querier = querier;
    }

    public String getQueryReason() {
        return queryReason;
    }

    public void setQueryReason(String queryReason) {
        this.queryReason = queryReason;
    }
}
