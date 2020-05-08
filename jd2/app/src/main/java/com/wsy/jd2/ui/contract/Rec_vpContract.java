package com.wsy.jd2.ui.contract;


import com.wsy.jd2.base.BaseView;
import com.wsy.jd2.bean.NewsBean;
import com.wsy.jd2.net.ResultCallBack;

public class Rec_vpContract {


    public interface INewsView extends BaseView {
        void  setRecommendList(NewsBean newsBean);
    }
    public interface INewsMode{
        <T> void getRecommendList(String tabID, ResultCallBack<T> iNetCallBack);
    }
    public interface INewsPresenter{
        void getRecommend(String string);
    }
}
