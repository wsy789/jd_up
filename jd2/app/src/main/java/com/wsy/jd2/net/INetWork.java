package com.wsy.jd2.net;

import java.util.HashMap;

/**
 *
 */
public interface INetWork {
//    get
//    post

    <T> void get(String url, ResultCallBack<T> netCallBack);
    <T> void get(String url, HashMap<String, String> s, ResultCallBack<T> netCallBack);

    <T> void post(String url, ResultCallBack<T> netCallBack);
    <T> void post(String url, HashMap<String, String> s, ResultCallBack<T> netCallBack);



}
