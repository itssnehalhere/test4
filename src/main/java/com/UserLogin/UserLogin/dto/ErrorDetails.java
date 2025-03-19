package com.UserLogin.UserLogin.dto;

import java.util.Date;

public class ErrorDetails {
private String getMessage;
private Date date;
private String webRequest;

    public ErrorDetails(String getMessage, Date date, String webRequest) {
        this.getMessage = getMessage;
        this.date = date;
        this.webRequest = webRequest;
    }

    public String getGetMessage() {
        return getMessage;
    }

    public Date getDate() {
        return date;
    }

    public String getWebRequest() {
        return webRequest;
    }
}
