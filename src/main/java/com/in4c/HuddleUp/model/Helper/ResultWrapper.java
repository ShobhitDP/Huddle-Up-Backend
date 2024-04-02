package com.in4c.HuddleUp.model.Helper;

public class ResultWrapper<T> {
    private T data;
    private String message;

    public ResultWrapper(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
