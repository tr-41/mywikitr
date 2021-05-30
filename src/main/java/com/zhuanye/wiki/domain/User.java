package com.zhuanye.wiki.domain;

public class User {
    //用户ID
    private Long id;
    //用户登录名
    private String loginName;
    //用户名称
    private String name;
    //用户登录密码
    private String password;
    //用户是否为系统拉黑用户
    private Boolean block;
    //用户是否达到系统有效编辑级别
    private Boolean level;
    //用户类的Getter和Setter函数
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getBlock() {
        return block;
    }

    public void setBlock(Boolean block) {
        this.block = block;
    }

    public Boolean getLevel() {
        return level;
    }

    public void setLevel(Boolean level) {
        this.level = level;
    }
    //用户类的toString()函数
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginName=").append(loginName);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", block=").append(block);
        sb.append(", level=").append(level);
        sb.append("]");
        return sb.toString();
    }
}