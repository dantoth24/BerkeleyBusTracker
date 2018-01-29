package com.example.dan.myapplication;

import android.graphics.Color;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private FusedLocationProviderClient mFusedLocationClient;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng berk = new LatLng(37.871798, -122.260777);
        LatLng top = new LatLng(37.86, -122.27);
        LatLng bottom = new LatLng(37.88, -122.25);

        try {
             Task get_loc = mFusedLocationClient.getLastLocation();
            Location location = null;
                            if (location != null) {
                                LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
                                MarkerOptions me = new MarkerOptions().position(loc);
                                mMap.addMarker(me);
                                // Logic to handle location object
                            }

                    ;
        } catch (SecurityException e) {

        }
        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(top, bottom).width(5).color(Color.RED));
        mMap.setMinZoomPreference(15);
        LatLngBounds bounds = new LatLngBounds(top, bottom);
        //mMap.setLatLngBoundsForCameraTarget(bounds);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(berk));
        if (mMap.isMyLocationEnabled()) {
            //MarkerOptions me = new MarkerOptions().position();
            //mMap.addMarker(me);
        }
    }
}
