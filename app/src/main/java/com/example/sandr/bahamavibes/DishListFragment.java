package com.example.sandr.bahamavibes;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sandr.bahamavibes.db.AppDatabase;


import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DishListFragment extends Fragment {

    //Declare  List to hold dishes
    private List <Dishes> dishes;

    //Declare  the dishes adapter object.
    private DishesAdapter adapter;

    //Declare recyclerView object
    private RecyclerView recyclerView;

    private   AppDatabase mDB; // to get a database instance.


    public DishListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.food_tab, container, false);

        //Create an instance of the database
        mDB = AppDatabase.getINSTANCE(this.getContext());









        //populate the arrayList
        populateArrayList();

        //inflate the recyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);



        return view;
    }

    public void populateArrayList(){

        new AsyncTask<Void,Void,List<Dishes>>(){

            @Override
            protected List<Dishes>doInBackground(Void... voids) {

        mDB.dishesModel().deleteAll(); // delete all previous objects in the database List array

       // Create and add objects to the databases's List
        Dishes grouperFinger = new Dishes("Grouper Fingers","Serving Size: 4oz","Calories: 210","Fat: 57g",R.drawable.grouper,1);
        mDB.dishesModel().insertDish(grouperFinger);





        Dishes conchSalad = new Dishes("Conch Salad","Serving Size: 16oz","Calories: 320","Fat: 4g",R.drawable.conchsalad,2);
        mDB.dishesModel().insertDish(conchSalad);


        Dishes crabDough = new Dishes("Crab n Dough","Serving Size: 16oz","Calories: 453","Fat: 13g",R.drawable.crabndough,3);
        mDB.dishesModel().insertDish(crabDough);


        Dishes steamedConch = new Dishes("Steamed Conch","Serving Size: 16oz","Calories: 140","Fat: 1g",R.drawable.steamedconch,4);
        mDB.dishesModel().insertDish(steamedConch);


        Dishes stewFish = new Dishes("Stew Fish","Serving Size: 16oz","Calories: 217","Fat: 9g",R.drawable.stewfish,5);
        mDB.dishesModel().insertDish(stewFish);


        Dishes sheepTongue = new Dishes("Sheeps Tongue","Serving Size: 16oz","Calories: 234","Fat: 17g",R.drawable.sheeptongue,6);
        mDB.dishesModel().insertDish(sheepTongue);


        Dishes  guava = new Dishes("Guavaduff","Serving Size: 16oz","Calories: 190","Fat: 25.9g",R.drawable.guavaduffa,7);
        mDB.dishesModel().insertDish(guava);


        Dishes boiledFish = new Dishes("Boiled Fish","Serving Size: 16oz","Calories: 112","Fat: 4g",R.drawable.boilbdfish,8);
        mDB.dishesModel().insertDish(boiledFish);


        /*
          Fill the data set for the adapter with the objects that were inserted into the databases List.
         */

                return mDB.dishesModel().findAllDishes();
            }

            @Override
            protected void onPostExecute(List<Dishes> dishesList) {

                dishes = dishesList;

                //create the adapter
                adapter = new DishesAdapter(dishes,getActivity()); //context is the parent activity

                //set the adapter
                recyclerView.setAdapter(adapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



            }
        }.execute();

    }

}
