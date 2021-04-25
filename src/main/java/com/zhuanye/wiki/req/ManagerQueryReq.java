package com.zhuanye.wiki.req;

public class ManagerQueryReq extends PageReq {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ManagerQueryReq{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
