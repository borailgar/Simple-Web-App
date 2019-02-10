package com.saaspass.Validator;

import java.net.HttpURLConnection;
import java.net.URL;

public class Check {
    public static Integer isValid(String url) throws Exception{
        URL newUrl = new URL(url);
        HttpURLConnection con = (HttpURLConnection) newUrl.openConnection();
        con.setRequestMethod("GET");
        if (con.getResponseCode()==200){
            return 1;
        }
        else
            return con.getResponseCode();
    }
}
