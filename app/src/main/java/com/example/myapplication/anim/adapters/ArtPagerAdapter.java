package com.example.myapplication.anim.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.anim.ArtDetailFragment;
import com.example.myapplication.anim.models.Artsy;

import java.util.ArrayList;

public class ArtPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Artsy> mArtsies;

    public ArtPagerAdapter(FragmentManager fm, ArrayList<Artsy> artsies) {
        super(fm);
        mArtsies = artsies;
    }

    @Override
    public Fragment getItem(int position) {
        return ArtDetailFragment.newInstance(mArtsies.get(position));
    }

    @Override
    public int getCount() {
        return mArtsies.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mArtsies.get(position).getTitle();
    }
}

