package com.saaspass.barcode;

public class BarcodeRequest {
    private BarcodeType type;
    private String session;

    public BarcodeType getType() {
        return type;
    }

    public void setType(BarcodeType type) {
        this.type = type;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public enum BarcodeType {
        IL, IR, BT, ILIR, ILBT;

    }
}
