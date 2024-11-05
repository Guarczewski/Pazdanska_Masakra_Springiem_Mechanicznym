package com.example.springwithsql.Database.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long logID;
    protected String logHeader, logMessage, logDetails;
    protected LocalDateTime logDate;
    protected String logUser, logUserRole;

    public Log() {
        this.logHeader = "unknown";
        this.logMessage = "unknown";
        this.logDetails = "unknown";
        this.logDate = LocalDateTime.now();
        this.logUser = "unknown";
        this.logUserRole = "unknown";
    }

    public Log(String logHeader, String logMessage, String logDetails, String logUser, String logUserRole) {
        this.logHeader = logHeader;
        this.logMessage = logMessage;
        this.logDetails = logDetails;
        this.logDate = LocalDateTime.now();
        this.logUser = logUser;
        this.logUserRole = logUserRole;
    }

    public long getLogID() {
        return logID;
    }

    public void setLogID(long logID) {
        this.logID = logID;
    }

    public String getLogHeader() {
        return logHeader;
    }

    public void setLogHeader(String logHeader) {
        this.logHeader = logHeader;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogDetails() {
        return logDetails;
    }

    public void setLogDetails(String logDetails) {
        this.logDetails = logDetails;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public String getLogUserRole() {
        return logUserRole;
    }

    public void setLogUserRole(String logUserRole) {
        this.logUserRole = logUserRole;
    }
}



