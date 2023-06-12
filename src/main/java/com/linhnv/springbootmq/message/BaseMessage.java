package com.linhnv.springbootmq.message;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class BaseMessage <T> implements Serializable {
    private Action action;
    private T data;

    public BaseMessage() {
    }

    public BaseMessage(Action action, T data) {
        this.action = action;
        this.data = data;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
