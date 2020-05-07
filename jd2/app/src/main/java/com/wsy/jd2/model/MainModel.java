package com.wsy.jd2.model;

import android.util.Log;

import com.wsy.jd2.base.BaseModel;
import com.wsy.jd2.bean.TopicBean;
import com.wsy.jd2.net.HttpUtil;
import com.wsy.jd2.net.ResultSubScriber;
import com.wsy.jd2.net.RxUtils;


//网络框架：1.每次都要写的生成网络接口对象ApiService
//          2.切换线程
//          3.观察者
public class MainModel extends BaseModel {
    public void getDate() {
/*
        new Retrofit.Builder()
                .baseUrl(Constants.sBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getTopic(1,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TopicBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TopicBean topicBean) {
                        Log.i("Observer", "onNext: "+topicBean.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
//背压  Flowable

        ResourceSubscriber<TopicBean> resourceSubscriber = new Retrofit.Builder()
                .baseUrl(Constants.sBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getTopic2(1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<TopicBean>() {
                    //ResourceSubscriber  观察者一种，专门配合Flowable使用，
                    //resourceSubscriber有返回值，是Disposable子类
                    @Override
                    public void onNext(TopicBean topicBean) {
                        Log.i("ResourceSubscriber", "onNext(背压): " + topicBean.toString());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
*/
//方法一
        ResultSubScriber<TopicBean> subscribe = HttpUtil.getInstance()
                .getApiService()
                .getTopic2(1, 10)
                .compose(RxUtils.<TopicBean>rxSchedulerHelper())//compose:被观察者调用
                .subscribeWith(new ResultSubScriber<TopicBean>() {
                    @Override
                    protected void onSuccess(TopicBean topicBean) {
                        Log.i("tag", "onSuccess: " + topicBean);
                    }
                });
        addDisposable(subscribe);
       /* //方法二
        addDisposable(HttpUtil.getInstance()
                .getApiService()
                .getTopic2(1, 10)
                .compose(RxUtils.<TopicBean>rxSchedulerHelper())//compose:被观察者调用
                .subscribeWith(new ResultSubScriber<TopicBean>() {
                    @Override
                    protected void onSuccess(TopicBean topicBean) {
                        Log.i("tag", "onSuccess: " + topicBean);
                    }
                })
        );*/

    }
}
