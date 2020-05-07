package com.wsy.jd2.ui.contract;

import com.wsy.jd2.base.BaseView;
import com.wsy.jd2.bean.ColunmBean;
import com.wsy.jd2.bean.NewsBean;
import com.wsy.jd2.net.ResultCallBack;

public class RecommendContract {

    public interface IRecommendView extends BaseView {
        void  setRecommendList(NewsBean string);
        void setColumList(ColunmBean columList);
    }
    public interface IRecommendMode{
        <T> void getRecommendList(String id, ResultCallBack<T> iNetCallBack);
        <T> void getColumList(ResultCallBack<T> iNetCallBack);
    }


    public interface IRecommendPresenter {

        void getColumList();
        void getRecommendList(String id);

    }


}
