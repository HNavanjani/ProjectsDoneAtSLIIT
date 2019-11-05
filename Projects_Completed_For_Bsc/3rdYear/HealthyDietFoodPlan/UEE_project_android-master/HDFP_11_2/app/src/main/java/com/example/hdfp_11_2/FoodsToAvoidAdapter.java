package com.example.hdfp_11_2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hdfp_11_2.foodstoAvoidFragments.FoodsToAvoidFragment1;
import com.example.hdfp_11_2.foodstoAvoidFragments.FoodsToAvoidFragment2;
import com.example.hdfp_11_2.foodstoAvoidFragments.FoodsToAvoidFragment3;
import com.example.hdfp_11_2.foodstoAvoidFragments.FoodsToAvoidFragment4;
import com.example.hdfp_11_2.foodstoAvoidFragments.FoodsToAvoidFragment5;
import com.example.hdfp_11_2.foodstoAvoidFragments.FoodsToAvoidFragment6;
import com.example.hdfp_11_2.foodstoAvoidFragments.FoodsToAvoidFragment7;

public class FoodsToAvoidAdapter extends FragmentPagerAdapter {
    public FoodsToAvoidAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new FoodsToAvoidFragment1();
        else if (position==1)
            return new FoodsToAvoidFragment2();
        else if (position==2)
            return new FoodsToAvoidFragment3();
        else if (position==3)
            return new FoodsToAvoidFragment4();
        else if (position==4)
            return new FoodsToAvoidFragment5();
        else if (position==5)
            return new FoodsToAvoidFragment6();
        else
            return new FoodsToAvoidFragment7();
    }


    @Override
    public int getCount() {
        return 7;
    }
}
