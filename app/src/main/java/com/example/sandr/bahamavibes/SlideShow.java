package com.example.sandr.bahamavibes;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SlideShow extends AppCompatActivity {

    ViewPager viewPager;

    Button Button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter =   new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);


        Button = (Button)findViewById(R.id.proceed_button1);

        Button.setOnClickListener(new View.OnClickListener() {

            /*
             Anonymous inner class allows you to override a super class method
             without subclassing it.
             */
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(intent);
            }
        });



    }

}
