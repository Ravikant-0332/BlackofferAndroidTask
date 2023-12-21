package com.example.blackcoffertask;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ExploreTabAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> fragments;
    ArrayList<String> fragmentNames;

    public ExploreTabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Fragment> fragments, ArrayList<String> fragmentNames) {
        super(fragmentManager, lifecycle);
        this.fragments = fragments;
        this.fragmentNames = fragmentNames;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
    public String getTitle(int position){
        return fragmentNames.get(position);
    }
}
