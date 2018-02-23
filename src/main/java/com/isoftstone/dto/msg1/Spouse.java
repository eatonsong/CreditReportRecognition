package com.isoftstone.dto.msg1;/*
 * @package_name com.isoftstone.dto.msg1
 * @date 2018/2/23 10:27  
 * @user Eaton
 */

import java.io.Serializable;

public class Spouse  implements Serializable {
    private static final long serialVersionUID = -8801286129172189218L;
    //姓名 证件类型 证件号码 工作单位 联系电话 配偶
    private String name;
    private String certtype;
    private String certno;
    private String employer;
    private String telephoneno;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCerttype() {
        return certtype;
    }

    public void setCerttype(String certtype) {
        this.certtype = certtype;
    }

    public String getCertno() {
        return certno;
    }

    public void setCertno(String certno) {
        this.certno = certno;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getTelephoneno() {
        return telephoneno;
    }

    public void setTelephoneno(String telephoneno) {
        this.telephoneno = telephoneno;
    }
}
