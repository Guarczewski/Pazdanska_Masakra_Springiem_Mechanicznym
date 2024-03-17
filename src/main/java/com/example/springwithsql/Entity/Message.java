package com.example.springwithsql.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int messageID;
    public LocalDateTime creationTime;
    public String content;

    public Message() {
        this.messageID = 0;
        this.creationTime = LocalDateTime.now();
        this.content = "";
    }
    public Message(String content) {
        this.creationTime = LocalDateTime.now();
        this.content = content;
    }

    public int getMessageID() {
        return messageID;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getContent() {
        return content;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageID=" + messageID +
                ", creationTime=" + creationTime +
                ", content='" + content + '\'' +
                '}';
    }
}
