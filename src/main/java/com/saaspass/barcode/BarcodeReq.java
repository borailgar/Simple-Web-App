package com.saaspass.barcode;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BarcodeReq {
    public static String _call_(String spURL) throws Exception {
        URL obj = new URL(spURL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
         in.close();
        JSONObject _json_ = new JSONObject(response.toString());
        String token= (String) _json_.get("barcodeimage");
        return token;
    }
}
