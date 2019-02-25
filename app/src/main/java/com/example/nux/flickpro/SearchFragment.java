package com.example.nux.flickpro;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SearchFragment extends Fragment {
    private static final String TAG = "SearchFragment";
    private ImageButton mButtonSearch;
    private ImageView mSunsetImage, mBeachImage, mWaterImage,
            mSkyImage, mFlowerImage, mNatureImage, mArtImage, mPeopleImage;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu, menu);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        mButtonSearch = view.findViewById(R.id.search_flickr_button);
        mSunsetImage=view.findViewById(R.id.sunset_image);
        mBeachImage=view.findViewById(R.id.beach_image);
        mWaterImage=view.findViewById(R.id.water_image);
        mSkyImage=view.findViewById(R.id.sky_image);
        mFlowerImage=view.findViewById(R.id.flower_image);
        mNatureImage=view.findViewById(R.id.nature_image);
        mArtImage=view.findViewById(R.id.art_image);
        mPeopleImage=view.findViewById(R.id.people_image);


        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchQueryFragment fragment=SearchQueryFragment.newInstance(null);
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .commit();

            }
        });

        mSunsetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchQueryFragment fragment=SearchQueryFragment.newInstance("Sunset");
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,fragment)
                        .commit();
            }
        });
        mBeachImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchQueryFragment fragment=SearchQueryFragment.newInstance("beach");
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,fragment)
                        .commit();
            }
        });
        mWaterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchQueryFragment fragment=SearchQueryFragment.newInstance("water");
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,fragment)
                        .commit();
            }
        });
        mSkyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchQueryFragment fragment=SearchQueryFragment.newInstance("sky");
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,fragment)
                        .commit();
            }
        });
        mFlowerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchQueryFragment fragment=SearchQueryFragment.newInstance("flower");
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,fragment)
                        .commit();
            }
        });
        mNatureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchQueryFragment fragment=SearchQueryFragment.newInstance("Nature");
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,fragment)
                        .commit();
            }
        });
        mArtImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchQueryFragment fragment=SearchQueryFragment.newInstance("Art");
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,fragment)
                        .commit();
            }
        });
        mPeopleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchQueryFragment fragment=SearchQueryFragment.newInstance("People");
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,fragment)
                        .commit();
            }
        });
        return view;
    }

    private void showOption() {
        mButtonSearch.setVisibility(View.VISIBLE);
    }

    private void hideOption() {
        mButtonSearch.setVisibility(View.GONE);
    }
    //AppBarLayout mAppBarLayout = view.findViewById(R.id.app_bar);

//        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = false;
//            int scrollRange = -1;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    isShow = true;
//                         showOption();
//                } else if (isShow) {
//                    isShow = false;
//                    hideOption();
//                }
//            }
//        });


}
