package com.example.sandr.bahamavibes;

//This class represents each of the native bahamian dishes.

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/*
 Parcelable is used to send objects to another activity.
 */

@Entity
public class Dishes implements Parcelable {

    @PrimaryKey
    @NonNull

    private int primaryKey; // primary key for dish

    //Fields
    private String dishName; // name of the dish

    private String servingSize; // serving size of the dish

    private String calories;// number of calories in the dish.

    private String fat;// amount of fat in the dish.




    private int  imageResourceId; // store the image of the dish.


    /*
     The constructor initializes the object upon creation
     */

    public Dishes(String dishName, String servingSize, String calories, String fat, int imageResourceId, int primaryKey){

        this.dishName = dishName; // set the name of the dish

        this.servingSize = servingSize; // set the serving size of the dish

        this.calories = calories; // set the calories of the dish

        this.fat = fat; // set the dat content of the dish

        this.primaryKey = primaryKey;


        this.imageResourceId = imageResourceId; // set the image of the dish.

    }

     /*
     The constructor initializes the object upon creation (without image)
     */


    @Ignore
    public Dishes(String dishName, String servingSize, String calories, String fat,int primaryKey){

        this.dishName = dishName; // set the name of the dish

        this.servingSize = servingSize; // set the serving size of the dish

        this.calories = calories; // set the calories of the dish

        this.fat = fat; // set the dat content of the dish

        this.primaryKey = primaryKey;


    }


    /*
      Constructor that takes  the parcel object and copies contents into  a new dishes object
     */
    protected Dishes(Parcel in) {
        dishName = in.readString();
        servingSize = in.readString();
        calories = in.readString();
        fat = in.readString();
        imageResourceId = in.readInt();
        primaryKey = in.readInt();
    }

    /*
     Creates dish item from the parcel
     */

    public static final Creator<Dishes> CREATOR = new Creator<Dishes>() {
        @Override

        //create dishes object from the parcel
        public Dishes createFromParcel(Parcel in) {
            return new Dishes(in);
        }

        @Override
        public Dishes[] newArray(int size) {
            return new Dishes[size];
        }
    };

    // return the dish name
    public String getDishName(){

        return this.dishName;
    }

    // return the serving size of the dish
    public String getServingSize(){

        return this.servingSize;
    }

    // return the number of calories in the dish
    public String getCalories(){

        return this.calories;
    }

    // return the fat content of the dish.
    public String getFat(){

        return this.fat;
    }



    public int getImageResourceId(){

        return this.imageResourceId;
    }

    public int getPrimaryKey(){

        return this.primaryKey;
    }

    // return the state of the object
    @Override
    public String toString() {
        return "Dishes{" +
                "dishName='" + dishName + '\'' +
                ", servingSize='" + servingSize + '\'' +
                ", calories='" + calories + '\'' +
                ", fat='" + fat + '\'' +
                ", imageResourceId=" + imageResourceId +
                '}';
    }


    /*
     describe the kinds of objects contained inside of the parcel
     */
    @Override
    public int describeContents() {
        return 0;
    }



    /*
      Flatten this object into a parcel
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dishName);
        dest.writeString(servingSize);
        dest.writeString(calories);
        dest.writeString(fat);
        dest.writeInt(imageResourceId);
    }
}
