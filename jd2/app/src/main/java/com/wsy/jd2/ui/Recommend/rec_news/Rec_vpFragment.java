package com.wsy.jd2.ui.Recommend.rec_news;


import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wsy.jd2.R;
import com.wsy.jd2.base.BaseFragment;
import com.wsy.jd2.base.Constants;
import com.wsy.jd2.bean.NewsBean;
import com.wsy.jd2.presenter.Rec_vpPresenter;
import com.wsy.jd2.ui.contract.Rec_vpContract;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Rec_vpFragment extends BaseFragment<Rec_vpPresenter> implements Rec_vpContract.INewsView {

    private String tabID;
    private RecyclerView mRecyclerView;
    private RlvMultiRecVpAdapter adapter;
    private NewsBean.DataBean dataBean;


    public Rec_vpFragment(String tabID) {
        this.tabID = tabID;
    }

    @Override
    protected Rec_vpPresenter initPresenter() {
        return new Rec_vpPresenter();
    }

    @Override
    protected void initDate() {
        mPresenter.getRecommendList(tabID);
    }


    @Override
    protected void initView(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        ArrayList<NewsBean.GoodsListItemBean> list1 = new ArrayList<>();
        adapter = new RlvMultiRecVpAdapter(list1);
//        mRecyHome.setAdapter(adapter);
        adapter.bindToRecyclerView(mRecyclerView);
    }

    @Override
    protected int getLayout() {
        return R.layout.list_recy;
    }

    @Override
    public void setRecommendList(NewsBean newsBean) {
        ArrayList<NewsBean.GoodsListItemBean> list = new ArrayList<>();
        Log.e("TAG", "推荐列表数据" + newsBean.toString());
        dataBean = newsBean.getData();
        //BrandListBean,头部Banner
//        List<NewsBean.DataBean.BannerListBean> brandList = newsBean.getData().getBanner_list();
        NewsBean.GoodsListItemBean bean = new NewsBean.GoodsListItemBean();
        bean.data = newsBean.getData();
        bean.itemType = NewsBean.GoodsListItemBean.TYPE_Banner;
        list.add(bean);
        //'view_type': '视图类型：1左图，2中间⼤图，3右图，4视频，5即时'
        List<NewsBean.DataBean.ArticleListBean> article_list = newsBean.getData().getArticle_list();
        for (int i = 0; i <article_list.size() ; i++) {
            NewsBean.DataBean.ArticleListBean articleListBean = article_list.get(i);
            NewsBean.GoodsListItemBean itemBean = new NewsBean.GoodsListItemBean();
            if (articleListBean.getView_type()==2){
                itemBean.itemType = NewsBean.GoodsListItemBean.TYPE_BigPicture;
            }else if (articleListBean.getView_type()==5){
                itemBean.itemType = NewsBean.GoodsListItemBean.TYPE_Scroll;
            }else {
                itemBean.itemType = NewsBean.GoodsListItemBean.TYPE_Lite;
            }
            itemBean.data=articleListBean;
            list.add(itemBean);
        }
        adapter.addData(list);
        /*//开头
        ArrayList<NewsBean.GoodsListItemBean> list = new ArrayList<>();
        Log.e("TAG", "推荐列表数据" + newsBean.toString());
        dataBean = newsBean.getData();
        //BrandListBean,头部Banner
//        List<NewsBean.DataBean.BannerListBean> brandList = newsBean.getData().getBanner_list();
        NewsBean.GoodsListItemBean bean = new NewsBean.GoodsListItemBean();
        bean.data = newsBean.getData();
        bean.itemType = NewsBean.GoodsListItemBean.TYPE_Banner;
        list.add(bean);

        //content :滚条
//        List<NewsBean.DataBean.FlashListBean> scrollList = newsBean.getData().getFlash_list();
            NewsBean.GoodsListItemBean scroll = new NewsBean.GoodsListItemBean();
//            NewsBean.DataBean.ArticleListBean date = scrollList.get(i);
            scroll.itemType = NewsBean.GoodsListItemBean.TYPE_Scroll;
            scroll.data = newsBean.getData();
            list.add(scroll);

        //content :条目
        List<NewsBean.DataBean.ArticleListBean> recommendList = newsBean.getData().getArticle_list();
        for (int i = 0; i < recommendList.size(); i++) {
            NewsBean.GoodsListItemBean pushContent = new NewsBean.GoodsListItemBean();
            NewsBean.DataBean.ArticleListBean date = recommendList.get(i);
            pushContent.itemType = NewsBean.GoodsListItemBean.TYPE_Lite;
            pushContent.data = date;
            list.add(pushContent);
        }
        //content :大图
        List<NewsBean.DataBean.ArticleListBean> bigPictureList = newsBean.getData().getArticle_list();
        for (int i = 0; i < bigPictureList.size(); i++) {
            NewsBean.GoodsListItemBean bigPictureContent = new NewsBean.GoodsListItemBean();
            NewsBean.DataBean.ArticleListBean date = bigPictureList.get(i);
            bigPictureContent.itemType = NewsBean.GoodsListItemBean.TYPE_BigPicture;
            bigPictureContent.data = date;
            list.add(bigPictureContent);
        }
        //最后
        adapter.addData(list);
*/
    }

}
