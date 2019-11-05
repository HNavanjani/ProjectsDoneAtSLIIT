package com.example.hdfp_11_2.foodstoAvoidFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.hdfp_11_2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodsToAvoidFragment1 extends Fragment {


    public FoodsToAvoidFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_foods_to_avoid_fragment1, container, false);
    }

}
