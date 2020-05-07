package com.wsy.jd2.net;

public interface ResultCallBack<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
