package com.example.foodhollow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void LoginSignUp(View view){

        if (view.getId() == R.id.logIn_button){
            Intent login = new Intent(getApplicationContext(), SignUp_Login.class);
            startActivity(login);
        }
        if (view.getId() == R.id.signUp_button){
            Intent signUp = new Intent(getApplicationContext(), SignUp_Login.class);
            startActivity(signUp);
        }
    }
    public void onlineRecipe(View view){
        if(view.getId() == R.id.potatoSaladPic){
            Uri uri = Uri.parse("https://www.olivemagazine.com/recipes/healthy/gochujang-roast-sweet-potato-with-mixed-grain-salad/");
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }
        if(view.getId() == R.id.gulyas){
            Uri uri = Uri.parse("https://www.olivemagazine.com/recipes/meat-and-poultry/paprika-chicken-goulash/");
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }
        if(view.getId() == R.id.porklentis){
            Uri uri = Uri.parse("https://www.olivemagazine.com/recipes/meat-and-poultry/balsamic-lentils-with-pork-fillet/");
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}