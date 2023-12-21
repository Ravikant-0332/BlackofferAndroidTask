package com.example.blackcoffertask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button refineBtn = findViewById(R.id.btn_refine);
        Button exploreBtn = findViewById(R.id.btn_explore);

        refineBtn.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), RefineActivity.class)));

        exploreBtn.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ExploreActivity.class)));

    }
}