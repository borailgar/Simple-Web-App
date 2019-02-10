package com.saaspass.TokenGeneration;

import static com.saaspass.Request.MakeRequest.call;

public class ComToken {
    public static String getComToken() throws Exception{
        String apiUrl = "https://www.saaspass.com/sd/rest";
        String comKey = "1idjmdwqrey89ecpkw";
        String comSecret ="x94zfvyollj37xpet60ahxdx7x6rujmu6t6x";

        String url = String.format("%s/%s/tokens?companysecret=%s", apiUrl, comKey, comSecret);
       return call(url);
    }
}
