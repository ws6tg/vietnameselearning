package com.gdufs.vietnameselearning.utils;

public class ResultJson {
    private int code;
    private Object data;

    public ResultJson(int i, Object data) {
        this.code=i;
        this.data=data;
    }

    public ResultJson() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
