package com.tablayoutdemo;

import  android.support.v4.app.*;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.tablayoutdemo.Fragment.*;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout=findViewById(R.id.frameLayout);
        tabLayout=findViewById(R.id.tablayout);

        TabLayout.Tab firstTab=tabLayout.newTab();
        firstTab.setText("First");
        tabLayout.addTab(firstTab);

        TabLayout.Tab secondTab=tabLayout.newTab();
        secondTab.setText("Second");
        tabLayout.addTab(secondTab);

        TabLayout.Tab thirdTab=tabLayout.newTab();
        thirdTab.setText("Third");
        tabLayout.addTab(thirdTab);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment=null;
                switch (tab.getPosition())
                {

                    case 0:
                        fragment=new FirstFragment();
                        break;
                    case 1:
                        fragment=new SecondFragment();
                        break;
                    case 2:
                        fragment=new ThirdFragment();
                        break;
                }
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.frameLayout,fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
