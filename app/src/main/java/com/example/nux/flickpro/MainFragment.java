package com.example.nux.flickpro;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        if (savedInstanceState == null) {
            Log.d(TAG, "Main fragment saveInstanceState =null");
            loadFragment(new ExploreFragment());
        } else {
            Log.d(TAG, "Main fragment saveInstanceState !=null");

        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        BottomNavigationView mNavigation = view.findViewById(R.id.bottom_navigation_view);

        mNavigation.setOnNavigationItemSelectedListener(mNavigationItemsSelected);

        return view;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mNavigationItemsSelected
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            String nameFragment;
            FragmentManager fm = getActivity().getSupportFragmentManager();
            switch (menuItem.getItemId()) {
                case R.id.menu_explore:

                    nameFragment = ExploreFragment.class.getName();
                    if (fm.findFragmentByTag(nameFragment) != null) {
                        fm.beginTransaction()
                                .replace(R.id.frame_layout, fm.findFragmentByTag(nameFragment))
                                .commit();
                    } else {
                        loadFragment(new ExploreFragment());
                    }

                    return true;
                case R.id.menu_search:
                    nameFragment = SearchFragment.class.getName();
                    if (fm.findFragmentByTag(nameFragment) != null) {
                        fm.beginTransaction()
                                .replace(R.id.frame_layout, fm.findFragmentByTag(nameFragment))
                                .commit();
                    } else {
                        loadFragment(new SearchFragment());
                    }

                    return true;
                case R.id.menu_add:
                    return true;
                case R.id.menu_account:
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment,fragment.getClass().getName())
                .addToBackStack(fragment.getClass().getName())
                .commit();
        Log.d(TAG, "addToBackStack: " + fragment.getClass().getSimpleName());
    }
    //https://stackoverflow.com/questions/43870485/how-to-handle-bottom-navigation-perfectly-with-back-pressed

}
