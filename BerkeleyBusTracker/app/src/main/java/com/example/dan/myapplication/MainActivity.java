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
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {

    }
}