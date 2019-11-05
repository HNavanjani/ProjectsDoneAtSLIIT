package com.example.hdfp_11_2.scheduleAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hdfp_11_2.dietplanschedulefragment.Day01ScheduleFragment01;
import com.example.hdfp_11_2.dietplanschedulefragment.Day01ScheduleFragment02;
import com.example.hdfp_11_2.dietplanschedulefragment.Day01ScheduleFragment03;
import com.example.hdfp_11_2.dietplanschedulefragment.Day01ScheduleFragment04;
import com.example.hdfp_11_2.dietplanschedulefragment.Day01ScheduleFragment05;
import com.example.hdfp_11_2.dietplanschedulefragment.Day01ScheduleFragment06;
import com.example.hdfp_11_2.dietplanschedulefragment.Day01ScheduleFragment07;

public class ScheduleAdapterSix extends FragmentPagerAdapter {
    public ScheduleAdapterSix(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if(position==0)
            return new Day01ScheduleFragment01();
        else  if(position==1)
            return new Day01ScheduleFragment02();
        else if (position==2)
            return new Day01ScheduleFragment03();

        else if (position==3)
            return new Day01ScheduleFragment04();
        else if (position==4)
            return new Day01ScheduleFragment05();
        else if (position==5)
            return new Day01ScheduleFragment06();
        else
            return new Day01ScheduleFragment07();

    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:return "dayOne";
            case 1:return "dayTwo";
            case 2:return "dayThree";
            case 3:return "dayFour";
            case 4:return "dayFive";
            default:return null;
        }
    }
}
