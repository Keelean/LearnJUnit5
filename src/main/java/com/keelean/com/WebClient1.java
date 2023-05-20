package com.keelean.com;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class WebClient1 {

    public String getContent(ConnectionFactory connectionFactory){
        String workingContent;
        StringBuffer content = new StringBuffer();
        try(InputStream is = connectionFactory.getData()){
            int count;
            while (-1 != (count = is.read())){
                content.append(new String(Character.toChars(count)));
            }
            workingContent = content.toString();

        }catch (Exception e){
            workingContent = null;
        }
        return workingContent;
    }
}
