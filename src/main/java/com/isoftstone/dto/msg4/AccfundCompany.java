package com.isoftstone.dto.msg4;/*
 * @package_name com.isoftstone.dto.msg4
 * @date 2018/2/14 22:35  
 * @user Eaton
 */

import java.io.Serializable;

public class AccfundCompany  implements Serializable {
    private static final long serialVersionUID = -5593526789671036128L;
    //缴费单位 信息更新日期
    private String no;
    private String organname;
    private String gettime;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getOrganname() {
        return organname;
    }

    public void setOrganname(String organname) {
        this.organname = organname;
    }

    public String getGettime() {
        return gettime;
    }

    public void setGettime(String gettime) {
        this.gettime = gettime;
    }
}
