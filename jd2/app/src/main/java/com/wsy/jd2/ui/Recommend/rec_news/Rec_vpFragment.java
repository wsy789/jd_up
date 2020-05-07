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
import com.wsy.jd2.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Rec_vpFragment extends BaseFragment<Rec_vpPresenter> implements Rec_vpContract.INewsView {

    private String tabID;
    private RecyclerView mRecyclerView;
    private RlvMultiRecVpAdapter adapter;


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
        //开头
        ArrayList<NewsBean.GoodsListItemBean> list = new ArrayList<>();
        Log.e("TAG", "推荐列表数据" + newsBean.toString());

        //BrandListBean,头部Banner
//        List<NewsBean.DataBean.BannerListBean> brandList = newsBean.getData().getBanner_list();
        NewsBean.GoodsListItemBean bean = new NewsBean.GoodsListItemBean();
        bean.data = newsBean.getData();
        bean.itemType = NewsBean.GoodsListItemBean.TYPE_Banner;
        list.add(bean);

        //content :滚条
//        List<NewsBean.DataBean.FlashListBean> scrollList = newsBean.getData().getFlash_list();
//        for (int i = 0; i < scrollList.size(); i++) {
            NewsBean.GoodsListItemBean scroll = new NewsBean.GoodsListItemBean();
//            NewsBean.DataBean.ArticleListBean date = scrollList.get(i);
            scroll.itemType = NewsBean.GoodsListItemBean.TYPE_Scroll;
            scroll.data = newsBean.getData();
            list.add(scroll);
//        }


        //content :条目
        List<NewsBean.DataBean.ArticleListBean> recommendList = newsBean.getData().getArticle_list();
        for (int i = 0; i < recommendList.size(); i++) {
            NewsBean.GoodsListItemBean pushContent = new NewsBean.GoodsListItemBean();
            NewsBean.DataBean.ArticleListBean date = recommendList.get(i);
            if (i%4==3){
                pushContent.itemType = NewsBean.GoodsListItemBean.TYPE_BigPicture;
            }else {
                pushContent.itemType = NewsBean.GoodsListItemBean.TYPE_Lite;
            }
            pushContent.data = date;
            list.add(pushContent);
        }
        //最后
        adapter.addData(list);

    }

/*    private int postion ;
    private RecyclerView mRecyHome;
    private RlvMultiRecVpAdapter adapter;

    public Rec_vpFragment(int i) {
        this.postion = i;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.textitem,container,false);
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.list_recy,container,false);
//initView(view);
        switch (postion){
            case 0:
                view.setBackgroundResource(R.color.colorPrimaryDark);
                break;
            case 1:

                view.setBackgroundResource(R.color.colorAccent);
                break;
            case 2:
                view.setBackgroundResource(R.color.colorPrimary);
                break;
            case 3:
                view.setBackgroundResource(R.color.colorPrimaryDark);
                break;
            case 4:
                view.setBackgroundResource(R.color.colorAccent);
                break;
            case 5:
                view.setBackgroundResource(R.color.colorPrimaryDark);
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
        }

//       view.setBackgroundResource(R.color.colorRed);
        return view;
    }

    private void initView(View view) {
        mRecyHome = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<NewsBean.GoodsListItemBean> list1 = new ArrayList<>();
        adapter = new RlvMultiRecVpAdapter(list1);
//        mRecyHome.setAdapter(adapter);
        adapter.bindToRecyclerView(mRecyHome);
    }*/
}
