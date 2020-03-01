package com.example.sandr.bahamavibes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DishDisplay extends AppCompatActivity {

    private ImageView image;

    private TextView textView;

    Dishes dishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_dish);

        Intent intent  = getIntent();

        //get the object sent over from the dish adapter
         dishes = intent.getParcelableExtra("dish");


        textView = (TextView)findViewById(R.id.recipes_text_view);




       image = (ImageView)findViewById(R.id.imageView);

       // set the image of the imageview
       image.setImageResource(dishes.getImageResourceId());


       //set the description of the dish
      setDishDescription();


    }

    /*
      Set the description of the dish
     */

    public void setDishDescription(){

        if(dishes.getDishName().equals("Conch Salad")){

            textView.setText(R.string.conch_recipe);
        }

        if(dishes.getDishName().equals("Grouper Fingers")){

            textView.setText(R.string.grouper_finger_recipe);
        }

        if(dishes.getDishName().equals("Crab n Dough")){

            textView.setText(R.string.crab_n_dough);
        }

        if(dishes.getDishName().equals("Steamed Conch")){

            textView.setText(R.string.steamed_conch);
        }
        if(dishes.getDishName().equals("Stew Fish")){

            textView.setText(R.string.stew_fish);
        }

        if(dishes.getDishName().equals("Sheeps Tongue")){

            textView.setText(R.string.sheep_tonugue);
        }

        if(dishes.getDishName().equals("Guavaduff")){

            textView.setText(R.string.guavaduff);
        }
        if(dishes.getDishName().equals("Boiled Fish")){

            textView.setText(R.string.boiled_fish);
        }



    }
}
