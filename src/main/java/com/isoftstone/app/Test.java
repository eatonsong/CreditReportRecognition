package com.isoftstone.app;/*
 * @package_name com.isoftstone.app
 * @date 2018/2/12 15:00  
 * @user Eaton
 */

import com.alibaba.fastjson.JSON;
import com.isoftstone.dto.Messages;
import com.isoftstone.location.TextLocations;
import com.isoftstone.util.PdfboxUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.IOException;

public class Test {
    private static XStream xStream;
    static {
        xStream = new XStream(new DomDriver());
    }
    public static void main(String[] args) throws IOException {
        Messages msg = new PdfboxUtil().getMessages("src/main/resources/pdf/002.pdf");
        String jsonStr = JSON.toJSONString(msg);
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xStream.toXML(msg);
        System.out.println(jsonStr);
        //System.out.println(xml);
    }
}
