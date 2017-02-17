package com.wangdong.githubdemo;

/**
 * Created by 汪栋 on 2017/2/17.
 */

public class MessageEvent {


    public MessageEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;
}
