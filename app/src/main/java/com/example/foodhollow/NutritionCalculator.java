package com.example.foodhollow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NutritionCalculator extends AppCompatActivity {


    String[] nutrition = new String[]{"beef","chicken","pork","lamb"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner dropdown = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, nutrition);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_calculator);

    }
}