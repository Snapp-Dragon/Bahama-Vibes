package com.example.sandr.bahamavibes;



//--------------------------------------------------------------------------
// Author            : Chad Farrington
// Company           : N/A
// Date              : 7/6/2018
//--------------------------------------------------------------------------
// Revision          : 1
// Dependencies      : 'com.google.android.gms:play-services-maps:15.0.1'
//                     'libs/YouTubeAndroidPlayerApi.jar'
//                     "android.arch.persistence.room:runtime:$room_version"
//                     'com.android.support:cardview-v7:27.1.1'
//
// Description       : App that introduces its users to Bahamian culture.
// Simulation Notes  : version of the emulator
// Synthesis Notes   :
// Application Notes :
// Simulator         :
// Parameters        :
//--------------------------------------------------------------------------
// Revision History  :amount of modifications you have made.
//--------------------------------------------------------------------------


import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    //Declare toolbar reference object
    Toolbar toolbar;

    ImageView image;

  //  android.support.v4.app.FragmentManager fm = getSupportFragmentManager();


    //Declare media player reference object
   static MediaPlayer mediaPlayer; // only a single copy is allowed in memory



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*
        android.support.v4.app.DialogFragment greetings = new GreetingFragment();

        greetings.show(fm,"greeting");
        */

        //Connect toolbar reference object to xml layout.
        toolbar = (Toolbar)findViewById(R.id.toolbar);


        //Set the toolbar title
        toolbar.setTitle("  " + "Bahama Vibes");


        //Set the logo for the app.
        toolbar.setLogo(R.drawable.nassau);


        //Set the toolbar as your appbar
        setSupportActionBar(toolbar);

        configureTabLayout();// build the tabLayout



      /*
       If media player is not equal to null get player position form shared preferene.
       */
       if(mediaPlayer !=null) {
           SharedPreferences prefs = getSharedPreferences("player", Context.MODE_PRIVATE);
           int position = prefs.getInt("playerPosition", 0);
           mediaPlayer.seekTo(position);
           mediaPlayer.start();
       }


     Log.i("In On create","Activity created");


    }

    private void configureTabLayout(){

        //create tablayout object and connect it the the xml view tab layout.
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);

        // Add the tabs to the tablayout
        tabLayout.addTab(tabLayout.newTab().setText(R.string.artist).setIcon(R.drawable.art));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.food).setIcon(R.drawable.food));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.monuments).setIcon(R.drawable.monument));


        //create view pager object and connect it to xml layout
        //The View Pager is a Layout manager that allows the user to flip left and right through pages of data.
        //You supply an implementation of a PagerAdapter to generate the pages that the view shows.
        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);


        //create view pager adapter it takes a fragment manager and the number of tabs as arguments.
        final PagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()) ;

        //set the adapter to the view pager.
        viewPager.setAdapter(adapter);

        //Add a listener that will be invoked whenever the page changes or is incrementally scrolled.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        /*
          public static class TabLayout.TabLayoutOnPageChangeListener is a
          ViewPager.OnPageChangeListener class which contains the necessary calls back
          to the provided TabLayout so that the tab position is kept in sync.
         */




        /*
        Add a TabLayout.OnTabSelectedListener that will be invoked when tab selection changes.
        TabLayout.OnTabSelectedListener is an interface that is invoked via an anonymous class.
         */

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            //called when a tab enters the selected state.
            public void onTabSelected(TabLayout.Tab tab) {
                // set the tab selected to the current fragment at said position.
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    /*
    This method is used set the menu to the toolbar.
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
      /*
      The onOptionsItemSelected() call back method is called  by the system when an item on your appbar is
      clicked. The Menu item object is passed to it as an argument.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        // if the user picks the cloud icon return it
        switch(item.getItemId()){
            case R.id.bahamas_anthem:
                // display a toast message stating the name of the song

                if(mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.hog);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer=null;
                            Toast.makeText(getApplicationContext(), "Stopping playback", Toast.LENGTH_LONG).show();
                        }
                    });


                    /*
                    SharedPreferences prefs = getSharedPreferences("player", Context.MODE_PRIVATE);
                    int position = prefs.getInt("playerPosition", 0);
                    mediaPlayer.seekTo(position);
                    mediaPlayer.start();
                    Toast.makeText(getApplicationContext(), R.string.hog, Toast.LENGTH_LONG).show();
                    */




                }

                else{


                    //display toast message stopping playback
                    Toast.makeText(getApplicationContext(), "Stopping playback", Toast.LENGTH_LONG).show();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }

                return true;

            case R.id.about:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(),R.string.created_by_chad,Toast.LENGTH_LONG).show();
                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }


    }


     @Override
    protected void onDestroy() {
         super.onDestroy();
         if (mediaPlayer != null) {
             /*
              On Destroy save the current position in the media player inside of a shared preference
              */


             SharedPreferences prefs = getApplicationContext().getSharedPreferences("player", Context.MODE_PRIVATE);
             SharedPreferences.Editor editor = prefs.edit();
             editor.putInt("playerPosition", mediaPlayer.getCurrentPosition());
             editor.commit();


         }


     }
}
