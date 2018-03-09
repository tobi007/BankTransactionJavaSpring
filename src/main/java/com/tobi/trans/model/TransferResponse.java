package com.tobi.trans.model;

import java.util.ArrayList;
import java.util.List;

public class TransferResponse {

    private boolean status;
    private String code;
    private String message;
    private List data = new ArrayList();

    public TransferResponse(){

    }

    public TransferResponse(boolean status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public TransferResponse(boolean status, String code, String message, List data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

}
