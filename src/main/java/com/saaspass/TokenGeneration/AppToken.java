package com.saaspass.TokenGeneration;

import static com.saaspass.Request.MakeRequest.call;

public class AppToken {
    public static String getAppToken() throws  Exception{
        String appKey = "FOF210IJBY0F5JHI";
        String apiUrl = "https://www.saaspass.com/sd/rest";
        String appPass = "KRRY4GSIIFC86ZHLDWRN03IY1DSQRMCV";

        String url = String.format("%s/applications/%s/tokens?password=%s", apiUrl, appKey, appPass);
        return call(url);
    }
}
