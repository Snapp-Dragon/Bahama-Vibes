package com.example.sandr.bahamavibes;

/*
  The Adapter class
  *Manages view holders
  * Binds view holders to their data by assigning a view position and
  * calls the onBindHolder method. The method uses view holder positions to determine
  * what the contents should be
 */

/*
  Point
  In the statement  "DishesAdapter.ViewHolder"  the "." notation signifies that viewHolder is a class
  within the DishAdapter class
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.ViewHolder> {

    CardView cardView;


      /*
   The list is also from the collections framework like array list.
   This list accepts objects of type Dishes
 */

      //Fields
    private List<Dishes> dishesList; // declaring a list object to hold dishes objects/

    private Context context; // allows access to application specific resources and classes.

    /*
     Constructor to initialize the Dishes adapter object
     */

    public DishesAdapter(List<Dishes> dishesList, Context context){

        this.dishesList = dishesList; // set the dishlist object

        this.context = context; // set the context object







    }

    /*
       The onCreateViewHolder method inflates the view and adds it to the view holder.

     */

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        //Create the layout inflater object
        LayoutInflater inflater = LayoutInflater.from(context);

        //inflate the layout
        View rawView = inflater.inflate(R.layout.dishes_row,parent,false);

        //place the inflated view inside the view holder
        ViewHolder dishesViewHolder = new ViewHolder(rawView);

       cardView = (CardView) rawView.findViewById(R.id.card_view);





        return dishesViewHolder;
    }


    /*
      The onBindViewHolder binds the views to their data
     */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {



       //set the colors of each cardView
       if(position == 0){

            cardView.setCardBackgroundColor(Color.parseColor("#FFF8E1"));

       }

        if(position == 1){

            cardView.setCardBackgroundColor(Color.parseColor("#FFECB3"));

        }
        if(position == 2){

            cardView.setCardBackgroundColor(Color.parseColor("#FFE082"));

        }
        if(position == 3){

            cardView.setCardBackgroundColor(Color.parseColor("#FFD54F"));

        }
        if(position == 4){

            cardView.setCardBackgroundColor(Color.parseColor("#FFCA28"));

        }
        if(position == 5){

            cardView.setCardBackgroundColor(Color.parseColor("#FFC107"));

        }
        if(position == 6){

            cardView.setCardBackgroundColor(Color.parseColor("#FFB300"));

        }


        if(position == 7){

            cardView.setCardBackgroundColor(Color.parseColor("#FFA000"));

        }




        //put an on click listener on to each item view holder
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //view holder at position 0
                if(position == 0){



                    //start a new activity if view holder at position 0 is clicked
                    Intent intent =  new Intent(view.getContext(),DishDisplay.class);

                    intent.putExtra("dish",dishesList.get(0));

                    view.getContext().startActivity(intent);


                }

                if(position == 1){

                    //start new activity if view holder at position 1 is clicked
                    Intent intent = new Intent(view.getContext(),DishDisplay.class);

                    // get the item at this position and send it over to main 2 activity
                    intent.putExtra("dish",dishesList.get(1));
                    view.getContext().startActivity(intent);

                }

                if(position == 2){

                    //start new activity if view holder at position 1 is clicked
                    Intent intent = new Intent(view.getContext(),DishDisplay.class);

                    // get the item at this position and send it over to main 2 activity
                    intent.putExtra("dish",dishesList.get(2));
                    view.getContext().startActivity(intent);

                }

                if(position == 3){

                    //start new activity if view holder at position 1 is clicked
                    Intent intent = new Intent(view.getContext(),DishDisplay.class);

                    // get the item at this position and send it over to main 2 activity
                    intent.putExtra("dish",dishesList.get(3));
                    view.getContext().startActivity(intent);

                }
                if(position == 4){

                    //start new activity if view holder at position 1 is clicked
                    Intent intent = new Intent(view.getContext(),DishDisplay.class);

                    // get the item at this position and send it over to main 2 activity
                    intent.putExtra("dish",dishesList.get(4));
                    view.getContext().startActivity(intent);

                }
                if(position == 5){

                    //start new activity if view holder at position 1 is clicked
                    Intent intent = new Intent(view.getContext(),DishDisplay.class);

                    // get the item at this position and send it over to main 2 activity
                    intent.putExtra("dish",dishesList.get(5));
                    view.getContext().startActivity(intent);

                }
                if(position == 6){

                    //start new activity if view holder at position 1 is clicked
                    Intent intent = new Intent(view.getContext(),DishDisplay.class);

                    // get the item at this position and send it over to main 2 activity
                    intent.putExtra("dish",dishesList.get(6));
                    view.getContext().startActivity(intent);

                }


                if(position == 7){

                    //start new activity if view holder at position 1 is clicked
                    Intent intent = new Intent(view.getContext(),DishDisplay.class);

                    // get the item at this position and send it over to main 2 activity
                    intent.putExtra("dish",dishesList.get(7));
                    view.getContext().startActivity(intent);

                }






            }
        });

        //Get the position  of the dish object in the list
        Dishes dishes = dishesList.get(position);

        //Make the viewholders dish name equal to current objects dish name.
        holder.dishName.setText(dishes.getDishName());
        //Make the viewholders serving size equal to current objects serving size.
        holder.servingSize.setText(dishes.getServingSize());
        //Make the viewholders calories equal to the current objects calories.
        holder.calories.setText(dishes.getCalories());
        //Make viewholders fat content equal to current objects fat content.
        holder.fat.setText(dishes.getFat());
        //Make view holders image equal to current objects image.
        holder.imageResourceId.setImageDrawable(context.getResources().getDrawable(dishes.getImageResourceId(),null));





    }

    /*
      Return the number of items in the data source
     */
    @Override
    public int getItemCount() {
        return dishesList.size();
    }


    /*
     View holder class
     */

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Fields
        public TextView dishName; // name of dish

        public TextView servingSize; // serving size of the dish

        public TextView calories; // number of calories in the dish

        public TextView fat;// fat content of the dish

        public ImageView imageResourceId; // image of  dish


        /*
        View holder constructor initializing the fields
         */

        public ViewHolder(View itemView) {
            super(itemView);

            dishName = (TextView) itemView.findViewById(R.id.name_text_view);

            servingSize = (TextView) itemView.findViewById(R.id.serving_text_view);

            calories = (TextView) itemView.findViewById(R.id.calories_text_view);

            fat = (TextView) itemView.findViewById(R.id.fat_text_view);

            imageResourceId = (ImageView) itemView.findViewById(R.id.image_view);


        }

    }
    }
