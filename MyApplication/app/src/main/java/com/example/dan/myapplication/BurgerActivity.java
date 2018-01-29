package com.example.dan.myapplication;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

import permissions.dispatcher.*;

@RuntimePermissions
public class BurgerActivity extends AppCompatActivity implements OnMapReadyCallback {


    public ArrayList<Circle> marks52 = new ArrayList<>();
    public ArrayList<Circle> marks51b = new ArrayList<>();
    public ArrayList<Circle> marks18 = new ArrayList<>();
    public ArrayList<Circle> marks6 = new ArrayList<>();

    void drawline(double[][] line, int r, int g, int b) {
        for (double[] coords : line) {
            LatLng spot = new LatLng(coords[0], coords[1]);
            mMap.addCircle(new CircleOptions().center(spot).radius(10).strokeColor(Color.argb(230, r, g, b )).fillColor(Color.argb(200, r, g, b )));
        }
    }

    public void makeLine(GoogleMap m, ArrayList<Circle> markers, double[][] coords, int r, int g, int b) {
        for (int i = 0; i < coords.length; i++) {
            LatLng spot = new LatLng(coords[i][0], coords[i][1]);
            Circle circle = m.addCircle(new CircleOptions()
                    .center(spot)
                    .radius(10)
                    .strokeColor(Color.argb(230, r, g, b))
                    .fillColor(Color.argb(230, r, g, b)));
            markers.add(circle);
        }

    }
    public void changeVisible(ArrayList<Circle> circles) {
        for (Circle x : circles) {
            x.setVisible(!x.isVisible());
        }
    }


    public double[][] coords52 = {
            {37.875298, -122.257953},
            {37.873470, -122.255221},
            {37.870997, -122.252831},
            {37.869297, -122.255144},
            {37.868531, -122.261781},
            {37.868166, -122.264124},
            {37.868293, -122.268042},
            {37.872170, -122.266203},
            {37.872108, -122.267979},
            {37.871516, -122.272674},
            {37.871413, -122.275191}
    };
    public double[][] coord51B = {
            {37.869297, -122.255144},
            {37.868531, -122.261781},
            {37.868166, -122.264124},
            {37.866703, -122.254200},
            {37.864175, -122.253711},
            {37.862024, -122.253481},
            {37.858589, -122.253268},
            {37.866461, -122.267809},
            {37.868293, -122.268042},
            {37.870093, -122.268146},
            {37.872108, -122.267979},
            {37.871516, -122.272674},
            {37.870346, -122.281475}
    };
    public double[][] coords18 = {
            {37.870093, -122.268146},
            {37.872108, -122.267979},
            {37.875261, -122.268630},
            {37.876520, -122.268753},
            {37.868192, -122.267990},
            {37.866461, -122.267809},
            {37.865110, -122.267368},
            {37.863909, -122.267216},
            {37.862092, -122.266998}
    };
    public double[][] coords6 = {
            {37.868006, -122.259029},
            {37.868646, -122.260255},
            {37.868531, -122.261781},
            {37.868166, -122.264124},
            {37.868828, -122.266165},
            {37.871342, -122.265813},
            {37.870093, -122.268146},
            {37.868192, -122.267990},
            {37.866461, -122.267809},
            {37.867201, -122.263217},
            {37.867422, -122.261417},
            {37.865815, -122.260993}
    };


    private FusedLocationProviderClient mFusedLocationClient;

    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        //setContentView(R.layout.activity_maps);
        //mySwitch = findViewById(R.id.switch1);
        //mySwitch.setChecked(true);

    }



   /* @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.burger, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_51b) {
            item.setChecked(!item.isChecked());
            changeVisible(marks51b);
            return true;
        } else if (id == R.id.action_52) {
            item.setChecked(!item.isChecked());
            changeVisible(marks52);
            return true;
        } else if (id == R.id.action_6) {
            item.setChecked(!item.isChecked());
            changeVisible(marks6);
            return true;
        } else if (id == R.id.action_18) {
            item.setChecked(!item.isChecked());
            changeVisible(marks18);
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        //mMap.addCircle(new CircleOptions().center(berk).radius(10000).strokeColor(Color.RED).fillColor(Color.BLUE));
        makeLine(mMap, marks51b, coord51B, 34,139,34);
        makeLine(mMap, marks6, coords6, 255, 128, 0);
        makeLine(mMap, marks18, coords18, 148,0, 211);
        makeLine(mMap, marks52, coords52, 30, 144, 255);
        BurgerActivityPermissionsDispatcher.get_locationWithPermissionCheck(this);
        mMap.setMinZoomPreference(15);
        LatLngBounds bounds = new LatLngBounds(top, bottom);
        mMap.setLatLngBoundsForCameraTarget(bounds);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(berk));



    }

    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    void get_location() {
        try {
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                MarkerOptions me = new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude()));
                                mMap.addMarker(me);
                            }
                        }
                    });
        } catch (SecurityException e) {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        BurgerActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }




}
