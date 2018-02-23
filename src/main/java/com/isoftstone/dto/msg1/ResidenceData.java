package com.isoftstone.dto.msg1;

import java.io.Serializable;

/**
 * 居住信息数据发生机构名称
 */
public class ResidenceData  implements Serializable {
    private static final long serialVersionUID = 1766649907471563613L;
    private String no;
    private String data;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
