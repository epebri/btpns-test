package com.mitrais.pos.model.response;

public class ResponseHandler {
    private Long code;
    private String message;
    private Object data;

    public ResponseHandler(Long code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseHandler() {
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
