package com.wsy.jd2.presenter;


import com.wsy.jd2.base.BasePresenter;
import com.wsy.jd2.model.MainModel;
import com.wsy.jd2.view.TopicView;
import com.wsy.jd2.view.VideoView;

public class VideoPresenter extends BasePresenter<VideoView> {

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
