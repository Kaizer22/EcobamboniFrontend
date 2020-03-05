package com.example.ecobambonifrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void onHelpClick(View v){
        Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
        startActivity(intent);
    }
}
