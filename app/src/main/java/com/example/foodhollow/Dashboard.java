package com.example.foodhollow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

   private EditText dashName, dashEmail , dashPass , calorieAim , calorieLeft , calorieTaken;


    public void nutritionCalc(View view){
        if (view.getId() == R.id.btn_nutritionCalc){
            Intent nutrition = new Intent(getApplicationContext(), NutritionCalculator.class);
            startActivity(nutrition);
        }
    }
    public void enabler(View enabler){

        if(enabler.getId() == R.id.btn_nameChanger){
            dashName = findViewById(R.id.accountName);
            dashName.setEnabled(true);
        }
        if(enabler.getId() == R.id.btn_emailChanger){
            dashName = findViewById(R.id.accountEmail);
            dashName.setEnabled(true);
        }
        if(enabler.getId() == R.id.btn_passChanger){
            dashName = findViewById(R.id.accountPass);
            dashName.setEnabled(true);
        }
    }
    public void saveChanges(View view){
        dashName = findViewById(R.id.accountName);
        dashEmail = findViewById(R.id.accountEmail);
        dashPass = findViewById(R.id.accountPass);
        String name = dashName.getText().toString();
        String email = dashEmail.getText().toString();
        String pass =  dashPass.getText().toString();
        userRepository.getRepository(getApplicationContext()).update(name , email, pass);
        Toast.makeText(Dashboard.this, "Changes Successful", Toast.LENGTH_SHORT).show();
        startActivity(getIntent());
    }
        public void calculator(){

            calorieAim = findViewById(R.id.calorieAimNum);
            calorieTaken = findViewById(R.id.calorieOverallNum);
            calorieLeft = findViewById(R.id.calorieLeftNum);


                calorieAim.setText("0");
                calorieTaken.setText("0");
                calorieLeft.setText("0");

                String calorieaim = calorieAim.getText().toString();
                String caloritaken = calorieTaken.getText().toString();
                int aimedCalories = Integer.parseInt(calorieaim);
                int eatencalories = Integer.parseInt((caloritaken));
                int calorielefty =  aimedCalories - eatencalories;
                calorieLeft.setText(calorielefty);

        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        EditText caloriesLeft = findViewById(R.id.calorieLeftNum);
        caloriesLeft.setEnabled(false);
        dashName = findViewById(R.id.accountName);
        dashName.setEnabled(false);
        dashEmail =  findViewById(R.id.accountEmail);
        dashEmail.setEnabled(false);
        dashPass =  findViewById(R.id.accountPass);
        dashPass.setEnabled(false);
        SharedPreferences preferences = getSharedPreferences("FoodHollow", MODE_PRIVATE);
        String accName = preferences.getString("sharedName", "");
        String accEmail = preferences.getString("sharedEmail", "");
        String accPass = preferences.getString("sharedPass", "");
        dashName.setText(accName);
        dashEmail.setText(accEmail);
        dashPass.setText(accPass);



    }
}