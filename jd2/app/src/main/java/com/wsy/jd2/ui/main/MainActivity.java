package com.wsy.jd2.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import com.wsy.jd2.R;
import com.wsy.jd2.base.BaseActivity;
import com.wsy.jd2.base.BaseApp;
import com.wsy.jd2.base.BaseFragment;
import com.wsy.jd2.presenter.MainPresenter;
import com.wsy.jd2.ui.Recommend.RecommendFragment;
import com.wsy.jd2.ui.mine.MineFragment;
import com.wsy.jd2.ui.topic.TopicFragment;
import com.wsy.jd2.ui.video.VideoFragment;
import com.wsy.jd2.view.MainView;


import java.util.ArrayList;

import butterknife.OnClick;

//使用泛型就不需要P在使用的时候进行类型转换
public class MainActivity extends BaseActivity<MainPresenter> implements MainView {


/*    @BindView(R.id.vp_main)
    ViewPager mVpMain;
    @BindView(R.id.tab_main)
    TabLayout mTabMain;*/
    private ArrayList<String> mTitles;
    private ArrayList<BaseFragment> mFragments;
    private ArrayList<Integer> mImages;
    private ViewPager mMainVp;
    private TabLayout mMainTab;

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {
        mMainVp = (ViewPager) findViewById(R.id.vp_main);
        mMainTab = (TabLayout) findViewById(R.id.tab_main);
        initTitles();
        initImages();
        initFragment();
        VpMainAdapter adapter = new VpMainAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mMainVp.setAdapter(adapter);
        mMainTab.setupWithViewPager(mMainVp);
        //把已有的tab换成我们想要的图文形式就可以了
        for (int i = 0; i < mTitles.size(); i++) {
            TabLayout.Tab tab = mMainTab.getTabAt(i);
            //设置自定义布局
            tab.setCustomView(getTabView(i));
        }

    }

    private void initImages() {
        mImages = new ArrayList<>();
        mImages.add(R.drawable.recommend_select_drawable);
        mImages.add(R.drawable.video_select_drawable);
        mImages.add(R.drawable.topic_select_drawable);
        mImages.add(R.drawable.my_select_drawable);
    }

    //根据索引获取对应的tab的自定义view
    private View getTabView(int position) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.tab, null);
        TextView tv = inflate.findViewById(R.id.tab_tv);
        ImageView iv = inflate.findViewById(R.id.tab_img);
        tv.setText(mTitles.get(position));
        iv.setImageResource(mImages.get(position));
        return inflate;
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(RecommendFragment.newInstance());//推荐
        mFragments.add(VideoFragment.newInstance());//视频
        mFragments.add(TopicFragment.newInstance());//主题
        mFragments.add(MineFragment.newInstance());
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
     /*   mTitles.add(BaseApp.getRes().getString(R.string.recommend));
        mTitles.add(BaseApp.getRes().getString(R.string.topic));
        mTitles.add(BaseApp.getRes().getString(R.string.video));
        mTitles.add(BaseApp.getRes().getString(R.string.mine));*/
        mTitles.add("推荐");
        mTitles.add("视频");
        mTitles.add("分类");
        mTitles.add("我的");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.vp_main, R.id.tab_main})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.vp_main:
                break;
            case R.id.tab_main:
                break;
        }
    }
}
