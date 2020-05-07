package com.wsy.jd2.ui.Recommend;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wsy.jd2.ui.Recommend.rec_news.Rec_vpFragment;

import java.util.List;

public class Rec_vpAdapter extends FragmentPagerAdapter {
    List<Rec_vpFragment> fragments;

    public Rec_vpAdapter(@NonNull FragmentManager fm, List<Rec_vpFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
