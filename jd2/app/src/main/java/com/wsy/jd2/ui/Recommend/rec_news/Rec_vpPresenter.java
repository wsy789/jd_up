package com.wsy.jd2.ui.Recommend.rec_news;

import com.wsy.jd2.base.BasePresenter;
import com.wsy.jd2.bean.NewsBean;
import com.wsy.jd2.net.ResultCallBack;
import com.wsy.jd2.ui.contract.RecommendContract;

public class Rec_vpPresenter extends BasePresenter<Rec_vpContract.INewsView>implements RecommendContract.IRecommendPresenter {
    private Rec_vpContract.INewsMode iNewsMode;

    @Override
    public void getColumList() {

    }

    public Rec_vpPresenter() {

        iNewsMode = new Rec_vpModel();

    }

    @Override
    public void getRecommendList(String id) {
        iNewsMode.getRecommendList(id,new ResultCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {

                mView.setRecommendList(newsBean);
            }

            @Override
            public void onFail(String msg) {

            }


        });


    }

    @Override
    protected void initModel() {

    }
}
