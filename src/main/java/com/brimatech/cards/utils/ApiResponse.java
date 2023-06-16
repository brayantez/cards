package com.brimatech.cards.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<E> {

    public enum Status {
        FAILED, SUCCESS
    }

    public enum SortField {
        name, color, status, created_at
    }

    private Instant timestamp;

    private Status status;

    private SortField sortField;

    private String token;

    private E data;

    private List<E> dataList;

    private String message;

    public ApiResponse() {
        this.timestamp = Instant.now();
        this.status = Status.SUCCESS;
        this.message = "Completed";
        this.sortField = SortField.name;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SortField getSortField() {
        return sortField;
    }

    public void setSortField(SortField sortField) {
        this.sortField = sortField;
    }

    public List<E> getDataList() {
        return dataList;
    }

    public void setDataList(List<E> dataList) {
        this.dataList = dataList;
    }
}
