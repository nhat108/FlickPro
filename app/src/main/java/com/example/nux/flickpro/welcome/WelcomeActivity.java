package com.example.nux.flickpro.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.nux.flickpro.R;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            FragmentManager fm=getSupportFragmentManager();

            WelcomeFragment fragment=new WelcomeFragment();
            fm.beginTransaction().replace(R.id.fragment_container,fragment)
                    .commit();
        }

    }
}
