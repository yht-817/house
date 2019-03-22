package com.ruoyi.project.globalapp.main.domain;

/**
 * 评论列表的实体类
 */
public class GlobalComments {
    /**
     * 评论编码
     */
    private String commentNo;
    /**
     * 用户头像
     */
    private String userHead;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户编码
     */
    private String userNo;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论时间
     */
    private String commentTime;

    public String getCommentNo() {
        return commentNo;
    }

    public void setCommentNo(String commentNo) {
        this.commentNo = commentNo;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "GlobalComments{" +
                "commentNo='" + commentNo + '\'' +
                ", userHead='" + userHead + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userNo='" + userNo + '\'' +
                ", content='" + content + '\'' +
                ", commentTime='" + commentTime + '\'' +
                '}';
    }
}
