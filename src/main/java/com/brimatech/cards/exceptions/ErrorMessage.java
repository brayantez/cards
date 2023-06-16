package com.brimatech.cards.exceptions;

import java.util.Date;
import java.util.List;

public class ErrorMessage {

    private Date timestamp;
    private List<String> error;
    private String details;

    public ErrorMessage(Date timestamp, List<String> error, String details) {
        this.timestamp = timestamp;
        this.error = error;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
