package com.zhuanye.wiki.domain;

public class DocEdit {
    //文档编辑记录的用户ID
    private Long userId;
    //文档编辑记录中被编辑的文档的文档ID
    private Long wordId;
    //编辑文档的用户名称
    private String username;
    //被编辑文档的文档名称
    private String wordname;

    //文档编辑类的无参构造函数
    public DocEdit() {
    }
    //文档编辑类的有参构造函数
    public DocEdit(Long userId, Long wordId, String username, String wordname) {
        this.userId = userId;
        this.wordId = wordId;
        this.username = username;
        this.wordname = wordname;
    }
    //文档编辑类的Getter()和Settter()函数
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWordId() {
        return wordId;
    }

    public void setWordId(Long wordId) {
        this.wordId = wordId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWordname() {
        return wordname;
    }

    public void setWordname(String wordname) {
        this.wordname = wordname;
    }

    //文档编辑类的toString()函数
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", wordId=").append(wordId);
        sb.append(", username=").append(username);
        sb.append(", wordname=").append(wordname);
        sb.append("]");
        return sb.toString();
    }
}