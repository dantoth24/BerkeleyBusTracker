package com.example.dan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent2 = new Intent(this, BurgerActivity.class);
        //Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent2);
        //startActivity(intent);


    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {

    }
}