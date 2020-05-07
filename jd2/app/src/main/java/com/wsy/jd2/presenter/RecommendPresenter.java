package com.wsy.jd2.presenter;


import android.util.Log;

import com.wsy.jd2.base.BasePresenter;
import com.wsy.jd2.base.Constants;
import com.wsy.jd2.bean.ColunmBean;
import com.wsy.jd2.bean.NewsBean;
import com.wsy.jd2.model.MainModel;
import com.wsy.jd2.model.RecommendModel;
import com.wsy.jd2.net.ResultCallBack;
import com.wsy.jd2.view.MineView;
import com.wsy.jd2.view.RecommendView;

public class RecommendPresenter extends BasePresenter<RecommendView> {

    private RecommendModel recommendModel;

    @Override
    protected void initModel() {
        recommendModel = new RecommendModel();
        addModel(recommendModel);
    }

    public void getDate() {
        Log.i("111", "getDate: P层");
        recommendModel.getColumList(new ResultCallBack<ColunmBean>() {
            @Override
            public void onSuccess(ColunmBean colunmBean) {
                if (colunmBean.getCode() == Constants.SUCCESS_CODE) {
                    mView.getRecTab(colunmBean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
    public void getRecommendList(String id) {
        Log.i("111", "getRecommendList: P层");
        recommendModel.getRecommendList(id,new ResultCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                if (newsBean.getCode() == Constants.SUCCESS_CODE) {
                    mView.getRecList(newsBean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

}
