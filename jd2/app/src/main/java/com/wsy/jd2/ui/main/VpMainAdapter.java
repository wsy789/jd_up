package com.wsy.jd2.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wsy.jd2.base.BaseFragment;

import java.util.ArrayList;

public class VpMainAdapter extends FragmentPagerAdapter {
    private final ArrayList<BaseFragment> mFragments;
    private final ArrayList<String> mTitles;

    public VpMainAdapter(@NonNull FragmentManager fm, ArrayList<BaseFragment> mFragments, ArrayList<String> mTitles) {
        super(fm);
        this.mFragments = mFragments;
        this.mTitles = mTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
