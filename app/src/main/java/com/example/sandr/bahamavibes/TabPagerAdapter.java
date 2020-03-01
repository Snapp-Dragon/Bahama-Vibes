package com.example.sandr.bahamavibes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {
    /*
      Fragment Pager adapter populates pages inside of a view Pager. The
      Fragment Pager adapter represents each page as a fragment that is persistently
      kept in the fragment manager as long as the user can return to the page.
     */

    int tabCount; // to hold the number of tabs

    public TabPagerAdapter(FragmentManager fm, int numberOfTabs){ // the pager adapter is passed,
                                                                  // the fragment manager and the
                                                                  // number of tabs.
        //super class constructor
        super(fm);

        this.tabCount =numberOfTabs; // set tabCount to the number of tabs passed to the adapter
    }




    /*
     The get item method returns a fragment
     based on the current tab position

     */
    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                return new JunkanooFragment();

            case 1:
                return new DishListFragment();

            case 2:
                return new MonumentsFragment();

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
