package com.xh.mysite.rest.publicvo;

import java.io.Serializable;

/**
 * author  Xiao Hong
 * date  2020/6/20 16:00
 * description
 */

public class RequestVO<T> implements Serializable {

    private T params;

    public RequestVO(T t) {
        this.params = t;
    }

    public RequestVO() {
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "RequestVO{" +
                "params=" + params.toString() +
                '}';
    }
}
