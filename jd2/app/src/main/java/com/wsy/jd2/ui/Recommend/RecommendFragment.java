package com.wsy.jd2.ui.Recommend;


import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.wsy.jd2.R;
import com.wsy.jd2.base.BaseFragment;
import com.wsy.jd2.bean.ColunmBean;
import com.wsy.jd2.bean.NewsBean;
import com.wsy.jd2.presenter.RecommendPresenter;
import com.wsy.jd2.ui.Recommend.rec_news.Rec_vpFragment;
import com.wsy.jd2.ui.Recommend.rec_news.RlvMultiRecVpAdapter;
import com.wsy.jd2.view.RecommendView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendView {
    TabLayout tabLayout;
    ViewPager viewPager;
    private RecyclerView mRecyHome;
    private RlvMultiRecVpAdapter adapter;
    List<Rec_vpFragment> rec_vpFragments = new ArrayList<>();
    private List<ColunmBean.DataBean.ListBean> list;

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    @Override
    protected RecommendPresenter initPresenter() {
        return new RecommendPresenter();
    }

    @Override
    protected void initDate() {
        mPresenter.getDate();
    }

    @Override
    protected void initView(View view) {
        tabLayout = view.findViewById(R.id.mytablayout);

        viewPager = view.findViewById(R.id.myviewpage);

    /*    for (int i = 0; list.size() < 10; i++) {
            TextView textView = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.textitem, null);
//            TextView textView = view.findViewById(R.id.my_tab_text);
            textView.setGravity(Gravity.CENTER);
            textView.setText(list.get(i).getName());
            tabLayout.addTab(tabLayout.newTab().setCustomView(textView), i);
        }*/


     /*   View view_recom = LayoutInflater.from(getActivity()).inflate(R.layout.list_recy,null);

        getList(view_recom);*/

    }

    private void getList(View view) {
        mRecyHome = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<NewsBean.GoodsListItemBean> list1 = new ArrayList<>();
        adapter = new RlvMultiRecVpAdapter(list1);
//        mRecyHome.setAdapter(adapter);
        adapter.bindToRecyclerView(mRecyHome);
    }

    private void initListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i = 0; i < list.size(); i++) {
                    TextView tabAt = (TextView) tabLayout.getTabAt(i).getCustomView();
                    tabAt.setBackgroundResource(R.color.white);
                }
                GradientDrawable drawable = new GradientDrawable();
                drawable.setCornerRadius(50);

                TextView customView = (TextView) tab.getCustomView();
                drawable.setStroke(1, Color.parseColor("#ff00ff"));
                drawable.setColor(Color.parseColor("#"+list.get(tab.getPosition()).getBack_color()));
                customView.setBackground(drawable);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        /*tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i = 0; i < list.size(); i++) {
                    TextView tabAt = (TextView) tabLayout.getTabAt(i).getCustomView();
                    tabAt.setBackgroundResource(R.color.white);
                }

                TextView customView = (TextView) tab.getCustomView();
                switch (tab.getPosition()) {
                    case 0:
//                        customView.setBackgroundResource(R.color.colorPrimaryDark);
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(50);
                        drawable1.setStroke(1, Color.parseColor("#ff00ff"));
                        drawable1.setColor(Color.parseColor("#ff00ff"));
                        customView.setBackground(drawable1);
                        break;
                    case 1:
                        GradientDrawable drawable = new GradientDrawable();
                        drawable.setCornerRadius(50);
                        drawable.setStroke(1, Color.parseColor("#ff00ff"));
                        drawable.setColor(Color.parseColor("#00ff00"));
                        customView.setBackground(drawable);
                        break;
                    case 2:
//                        customView.setBackgroundResource(R.color.colorAccent);
                        GradientDrawable drawable2 = new GradientDrawable();
                        drawable2.setCornerRadius(50);
                        drawable2.setStroke(1, Color.parseColor("#ff00ff"));
                        drawable2.setColor(Color.parseColor("#008577"));
                        customView.setBackground(drawable2);
                        break;
                    case 3:
                        GradientDrawable drawable3 = new GradientDrawable();
                        drawable3.setCornerRadius(50);
                        drawable3.setStroke(1, Color.parseColor("#ff00ff"));
                        drawable3.setColor(Color.parseColor("#FFEB3B"));
                        customView.setBackground(drawable3);
                        break;
                    case 4:
                        GradientDrawable drawable4 = new GradientDrawable();
                        drawable4.setCornerRadius(50);
                        drawable4.setStroke(1, Color.parseColor("#ff00ff"));
                        drawable4.setColor(Color.parseColor("#D81B60"));
                        customView.setBackground(drawable4);
                        break;
                    case 5:
                        GradientDrawable drawable5 = new GradientDrawable();
                        drawable5.setCornerRadius(50);
                        drawable5.setStroke(1, Color.parseColor("#ff00ff"));
                        drawable5.setColor(Color.parseColor("#03A9F4"));
                        customView.setBackground(drawable5);
                        break;
                    case 6:
                        GradientDrawable drawable6 = new GradientDrawable();
                        drawable6.setCornerRadius(50);
                        drawable6.setStroke(1, Color.parseColor("#ff00ff"));
                        drawable6.setColor(Color.parseColor("#FF9800"));
                        customView.setBackground(drawable6);
                        break;
                    case 7:
                        GradientDrawable drawable7 = new GradientDrawable();
                        drawable7.setCornerRadius(50);
                        drawable7.setStroke(1, Color.parseColor("#ff00ff"));
                        drawable7.setColor(Color.parseColor("#9C27B0"));
                        customView.setBackground(drawable7);
                        break;
                    case 8:
                        GradientDrawable drawable8 = new GradientDrawable();
                        drawable8.setCornerRadius(50);
                        drawable8.setStroke(1, Color.parseColor("#ff00ff"));
                        drawable8.setColor(Color.parseColor("#2196F3"));
                        customView.setBackground(drawable8);
                        break;
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void getRecTab(ColunmBean colunmBean) {

        Log.e("TAG", "当前TabLayout的栏目数据：" + colunmBean.toString());
//        栏目请求成功了
        if (colunmBean.getCode() == 1) {
            list = colunmBean.getData().getList();
            for (int i = 0; i <list.size(); i++) {
                //                创建咱们得Fragment
                Rec_vpFragment  newsFragment = new Rec_vpFragment(list.get(i).getId());
                rec_vpFragments.add(newsFragment);
            }

            Rec_vpAdapter adapter = new Rec_vpAdapter(getActivity().getSupportFragmentManager(), rec_vpFragments);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);

            for (int i = 0; i < list.size(); i++) {
                TextView textView = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.textitem, null);
//            TextView textView = view.findViewById(R.id.my_tab_text);
                textView.setGravity(Gravity.CENTER);
                textView.setText(list.get(i).getName());
                tabLayout.addTab(tabLayout.newTab().setCustomView(textView), i);
            }
            initListener();
            mPresenter.getRecommendList(colunmBean.getData().getList().get(0).getId());
//            mPresenter.getDate();
        }
    }

    @Override
    public void getRecList(NewsBean string) {
        Log.e("TAG", "对应栏目新闻请求i成功：" + string.toString());

    /*    Bundle bundle = new Bundle();
        bundle.putSerializable("list",ArrayList<NewsBean.DataBean.ArticleListBean> );
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        Rec_vpFragment rec_vpFragment = new Rec_vpFragment();
        rec_vpFragment.setArguments(bundle);*/


    }
}
