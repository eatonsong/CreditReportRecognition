package com.isoftstone.dto.msg1;

import java.io.Serializable;

/**
 * 居住信息
 */
public class Residence  implements Serializable {
    private static final long serialVersionUID = -7349640252885135307L;
    //编号 居住地址 居住状况 信息更新日期
    private String sortno;
    private String address;
    private String residencetype;
    private String gettime;

    public String getSortno() {
        return sortno;
    }

    public void setSortno(String sortno) {
        this.sortno = sortno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResidencetype() {
        return residencetype;
    }

    public void setResidencetype(String residencetype) {
        this.residencetype = residencetype;
    }

    public String getGettime() {
        return gettime;
    }

    public void setGettime(String gettime) {
        this.gettime = gettime;
    }
}
