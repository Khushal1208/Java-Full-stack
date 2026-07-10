package com.khushal.crudspringbootdemo.DTO;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionResponseDTO {
    private LocalDateTime timeStamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;
    private Map<String, String> feildErrors;

    public ValidationExceptionResponseDTO(LocalDateTime timeStamp, int statusCode, String error, String message, String path, Map<String, String> feildErrors) {
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
        this.feildErrors = feildErrors;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getFeildErrors() {
        return feildErrors;
    }

    public void setFeildErrors(Map<String, String> feildErrors) {
        this.feildErrors = feildErrors;
    }
}
