package com.example.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class Meal extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        tabLayout = findViewById(R.id.mtabl);
        viewPager = findViewById(R.id.mvp);

        tabLayout.setupWithViewPager(viewPager);

        VPadapter vPadapter = new VPadapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vPadapter.addFragment(new reco(), "We recommend");
        vPadapter.addFragment(new available(), "Also Available");
        vPadapter.addFragment(new others(), "Others");
        viewPager.setAdapter(vPadapter);


    }
}