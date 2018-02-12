package com.isoftstone.dto;/*
 * @package_name com.isoftstone.dto
 * @date 2018/2/12 15:01  
 * @user Eaton
 */

import org.apache.pdfbox.text.TextPosition;

public class Messages {
    TextPosition text;

    public TextPosition getText() {
        return text;
    }

    public void setText(TextPosition text) {
        this.text = text;
    }
}
