package com.example.hdfp_11_2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hdfp_11_2.exerciseFragments.exerciseFragment1;
import com.example.hdfp_11_2.exerciseFragments.exerciseFragment10;
import com.example.hdfp_11_2.exerciseFragments.exerciseFragment2;
import com.example.hdfp_11_2.exerciseFragments.exerciseFragment3;
import com.example.hdfp_11_2.exerciseFragments.exerciseFragment4;
import com.example.hdfp_11_2.exerciseFragments.exerciseFragment5;
import com.example.hdfp_11_2.exerciseFragments.exerciseFragment6;
import com.example.hdfp_11_2.exerciseFragments.exerciseFragment7;
import com.example.hdfp_11_2.exerciseFragments.exerciseFragment8;
import com.example.hdfp_11_2.exerciseFragments.exerciseFragment9;

public class ExerciseAdapter extends FragmentPagerAdapter {

    public ExerciseAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new exerciseFragment1();
        else  if(position==1)
            return new exerciseFragment2();
        else if (position==2)
            return new exerciseFragment3();

        else if (position==3)
            return new exerciseFragment4();
        else if (position==4)
            return new exerciseFragment5();
        else if (position==5)
            return new exerciseFragment6();
        else if (position==6)
            return new exerciseFragment7();
        else if (position==7)
            return new exerciseFragment8();
        else if (position==8)
            return new exerciseFragment9();
        else
            return new exerciseFragment10();

    }

    @Override
    public int getCount() {
        return 10;
    }
}
