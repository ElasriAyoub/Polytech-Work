package com.polytech.tindog.Message;

import java.util.Date;

public class MessageDto {
    private String messageBody;
    private Date createDate;
    private boolean sentByCurrentUser;

    public MessageDto(String messageBody, Date createDate, boolean sentByCurrentUser) {
        this.messageBody = messageBody;
        this.createDate = createDate;
        this.sentByCurrentUser = sentByCurrentUser;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isSentByCurrentUser() {
        return sentByCurrentUser;
    }

    public void setSentByCurrentUser(boolean sentByCurrentUser) {
        this.sentByCurrentUser = sentByCurrentUser;
    }
}
