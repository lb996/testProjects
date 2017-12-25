package com.lb.myeventbus;

/**
 * Created by bobml on 2017/12/21.
 */

public class FirstEvent {
    private String fmsg;

    public FirstEvent(String msg){
        this.fmsg=msg;
    }

    public String getMsg(){
        return fmsg;
    }
}
