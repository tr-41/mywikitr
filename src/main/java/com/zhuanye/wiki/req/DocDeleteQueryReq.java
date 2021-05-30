package com.zhuanye.wiki.req;

public class DocDeleteQueryReq extends PageReq{
    private Long userId;

    private Long wordId;

    private String username;

    private String wordname;

    public DocDeleteQueryReq() {
    }

    public DocDeleteQueryReq(Long userId, Long wordId, String username, String wordname) {
        this.userId = userId;
        this.wordId = wordId;
        this.username = username;
        this.wordname = wordname;
    }

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