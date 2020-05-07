package com.wsy.jd2.presenter;


import com.wsy.jd2.base.BasePresenter;
import com.wsy.jd2.model.MainModel;
import com.wsy.jd2.view.RecommendView;
import com.wsy.jd2.view.TopicView;

public class TopicPresenter extends BasePresenter<TopicView> {

    private MainModel mMainModel;

    public void getDate(){
        mMainModel.getDate();
    }

    @Override
    protected void initModel() {
        mMainModel = new MainModel();
        addModel(mMainModel);
    }
}
