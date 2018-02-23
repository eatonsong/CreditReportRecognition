package com.isoftstone.dto.msg1;

import java.io.Serializable;

public class ProfessionalData  implements Serializable {
    private static final long serialVersionUID = -5327964427820281777L;
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
