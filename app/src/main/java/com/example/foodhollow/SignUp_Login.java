package com.example.foodhollow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;

public class SignUp_Login extends AppCompatActivity {
    private static final String sharedPrefFile = "FoodHollow";
    private SharedPreferences sharedPreferences;
    boolean Login;


    EditText nameBox, emailBox , passwordBox , logEmail , logPass;
    String name , email, pass , alreadyEmail, alreadyPass;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__login);
        nameBox = findViewById(R.id.newUserName);
        emailBox = findViewById(R.id.newUserEmail);
        passwordBox = findViewById(R.id.newUserPassword);
        logEmail = findViewById(R.id.alreadyUserEmail);
        logPass = findViewById(R.id.alreadyUserPassword);
        sharedPreferences = getSharedPreferences("FoodHollow", MODE_PRIVATE);
        SharedPreferences.Editor preferenceEditor = sharedPreferences.edit();



    }

    public void NewUser(View submit) {
        if (submit.getId() == R.id.btn_signUp) {
            name = nameBox.getText().toString();
            email = emailBox.getText().toString();
            pass =  passwordBox.getText().toString();

            userRepository.getRepository(getApplicationContext()).insert(name, email, pass);

            SharedPreferences.Editor preferenceEditor = sharedPreferences.edit();

            preferenceEditor.putBoolean("isLogin",Login).commit();
            String userKeyName = "sharedName";
            String userKeyEmail = "sharedEmail";
            String userKeyPass = "sharedPass";
            preferenceEditor.putString(userKeyEmail, this.email);
            preferenceEditor.putString(userKeyName , this.name);
            preferenceEditor.putString(userKeyPass, this.pass);
            preferenceEditor.apply();
            Intent dashboard = new Intent(getApplicationContext(), Dashboard.class);
            startActivity(dashboard);
            Toast.makeText(SignUp_Login.this, "Registration successful", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(SignUp_Login.this, "Already existing user", Toast.LENGTH_SHORT).show();
        }
    }

    public void Check(View check) {
        alreadyEmail = logEmail.getText().toString();
        alreadyPass = logPass.getText().toString();

        if (check.getId() == R.id.btn_login) {
            if(userRepository.getRepository(getApplicationContext()).Check( alreadyEmail, alreadyPass)){
                Toast.makeText(SignUp_Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent dashboard = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(dashboard);

            }else{
                Toast.makeText(SignUp_Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}