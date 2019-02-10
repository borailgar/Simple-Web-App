package com.saaspass.barcode;

import static com.saaspass.barcode.BarcodeReq._call_;
import com.saaspass.TokenGeneration.AppToken;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.logging.Logger;

import com.saaspass.cons.Constants;


public class ResponseBarcode extends HttpServlet  {

    public String getBarcode(HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        String spUrl = String.format("%s/applications/%s/barcodes?type=%s&session=%s&token=%s",
					Constants.API_URL,
					Constants.APP_KEY,
                                       BarcodeRequest.BarcodeType.IL,
                                       session.getId(),
                                       AppToken.getAppToken());

       return _call_(spUrl);
    }

    private final static Logger log = Logger.getLogger(ResponseBarcode.class.getName());

    public String spUrl(HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();

            String url = String.format("%s/applications/%s/barcodes?type=%s&session=%s&token=%s",
		    			Constants.API_URL,
		    			Constants.APP_KEY,
                                        BarcodeRequest.BarcodeType.IL,
                                        session.getId(),
                                        AppToken.getAppToken()
                                      );
            log.info(url);

            return url;
    }

}
