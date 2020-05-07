package com.wsy.jd2.view;


import com.wsy.jd2.base.BaseView;
import com.wsy.jd2.bean.ColunmBean;
import com.wsy.jd2.bean.NewsBean;

public interface RecommendView extends BaseView {
    //    void setDate(String msg);
    void getRecTab(ColunmBean colunmBean);
    void  getRecList(NewsBean string);
}
