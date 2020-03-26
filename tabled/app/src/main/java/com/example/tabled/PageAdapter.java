package com.example.tabled;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
//        con un Swith case podemos mostrar el fragmento dependiendo que tabla está elegida
        switch (position){
            case 0: return new tab1();
            case 1: return new tab2();
            case 2: return new tab3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
