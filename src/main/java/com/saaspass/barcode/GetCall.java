package com.saaspass.barcode;

import javax.inject.Named;
import java.io.Serializable;

@Named("getCall")
public class GetCall implements Serializable {
    public String barcodeImage;

    public void setBarcodeImage(String barcodeImage) {
        this.barcodeImage = barcodeImage;
    }

    public String getBarcodeImage() {
        return barcodeImage;
    }
}
