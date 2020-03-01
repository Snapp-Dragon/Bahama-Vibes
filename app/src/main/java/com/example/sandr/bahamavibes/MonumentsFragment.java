package com.example.sandr.bahamavibes;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonumentsFragment extends Fragment implements OnMapReadyCallback{

    //Fields
    /*
     GoogleMap is the main class of the google maps android API and is the entry
     point of all methods related to the app. You cannot instantiate a GoogleMap
     object directly, rather you must obtain one form the getMapAsync method
     on the map fragment or MapView that you have added to your application.
     */
    GoogleMap myGoogleMap;


    /*
      MapView is a view which displays a Map with data obtained from the google Map service.
      when focused it will capture keypresses and touch gestures to move the map.
     */
    MapView myMapView;


    View myView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myMapView = (MapView) myView.findViewById(R.id.map);
        if(myMapView != null){
            myMapView.onCreate(null);
            myMapView.onResume();

            //returns a non null instance of the GoogleMap ready to be used.
            myMapView.getMapAsync(this);
        }
    }

    public MonumentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.monuments_tab, container, false);

        return myView;
    }

   // Bitmap.Config conf = Bitmap.Config.ARGB_8888;
   // Bitmap bmp = Bitmap.createBitmap(80, 80, conf);
   // Canvas canvas1 = new Canvas(bmp);




    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        myGoogleMap = googleMap; //instance of google map returned by getMapAsync method
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        /*
         Create objects for markers.
         */
          Monuments nassau = new Monuments("Nassau","Founded in 1670 by British Noblemen",25.047984,-77.355413,R.drawable.nassaum);
          Monuments queenStairCase = new Monuments("Queen's Staircase","66 steps hewn out by slaves in 1793 & 1794 ",25.0730802,-77.3376366,R.drawable.queens);
          Monuments slaveHouses = new Monuments("The 7 Slave Houses","Ruins of the slave's quarters",25.0138287,-77.55197529999998,R.drawable.slavehouses);
          Monuments fortCharlotte = new Monuments("Fort Charlotte","Built 18th century by British colonial governor Lord Dunmore",25.0769583,-77.3587326,R.drawable.fortch);
          Monuments fortMontagu = new Monuments("Fort Montagu","Four canon fort built in 1741",25.0737098,-77.30664430000001,R.drawable.fortm);



        /*
          Add Markers here
         */


        googleMap.addMarker(new MarkerOptions().position(new LatLng(nassau.getLat(),nassau.getLongitude())).title(nassau.getTitle()).snippet(nassau.getSnippet()).icon(BitmapDescriptorFactory.fromResource(nassau.getImageResourceId())));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(queenStairCase.getLat(),queenStairCase.getLongitude())).title(queenStairCase.getTitle()).snippet(queenStairCase.getSnippet()).icon(BitmapDescriptorFactory.fromResource(queenStairCase.getImageResourceId())));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(slaveHouses.getLat(),slaveHouses.getLongitude())).title(slaveHouses.getTitle()).snippet(slaveHouses.getSnippet()).icon(BitmapDescriptorFactory.fromResource(slaveHouses.getImageResourceId())));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(fortCharlotte.getLat(),fortCharlotte.getLongitude())).title(fortCharlotte.getTitle()).snippet(fortCharlotte.getSnippet()).icon(BitmapDescriptorFactory.fromResource(fortCharlotte.getImageResourceId())));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(fortMontagu.getLat(),fortMontagu.getLongitude())).title(fortMontagu.getTitle()).snippet(fortMontagu.getSnippet()).icon(BitmapDescriptorFactory.fromResource(fortMontagu.getImageResourceId())));
        CameraPosition Nassau = CameraPosition.builder().target(new LatLng(25.047984,-77.355413)).zoom(12).bearing(0).tilt(45).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Nassau));
    }
}
