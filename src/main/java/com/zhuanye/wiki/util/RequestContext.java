package com.zhuanye.wiki.util;


import java.io.Serializable;

public class RequestContext implements Serializable {

    //线程的本地变量
    private static ThreadLocal<String> remoteAddr = new ThreadLocal<>();

    //在接口入口获取IP，并给线程本地变量赋值
    public static String getRemoteAddr() {
        return remoteAddr.get();
    }

    //获取线程本地变量的值
    public static void setRemoteAddr(String remoteAddr) {
        RequestContext.remoteAddr.set(remoteAddr);
    }

}
