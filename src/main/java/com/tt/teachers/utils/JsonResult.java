package com.tt.teachers.utils;

public class JsonResult {
    private Integer status;//响应状态码
    private String msg; //响应消息
    private Object data;//响应数据


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult() {
    }

    public JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    //成功
    public static JsonResult ok(String msg,Object data) {
        return new JsonResult(200,msg,data);
    }

    //失败
    public static JsonResult no(String msg,Object data) {
        return new JsonResult(500,msg,data);
    }

}
