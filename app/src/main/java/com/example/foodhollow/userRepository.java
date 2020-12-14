package com.example.foodhollow;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;


public class userRepository {
    private static userRepository INSTANCE;
    private Context context;
    private loginDataDao loginDao;
    private loginData loginData;

    public String getUserName(){
        return loginData.getDataName();
    }
    public String getUserEmail(){
        return loginData.getDataEmail();
    }
    public String getUserPass(){
        return loginData.getDataPass();
    }
    public void addLoginValues() {
        SignUp_Login login =  new SignUp_Login();
        String name = login.getName();
        String email = login.getEmail();
        String pass = login.getPass();
        insert(name , email ,pass);
    }
    public void insert(String name , String email , String pass){
        loginData user = new loginData(name,email,pass);
        loginDao.insert(user);
    }
    public void update(String name , String email , String pass){
        loginData user = new loginData(name,email,pass);
        loginDao.update(user);
    }
    public boolean Check (String check , String checkPass){
        List<loginData> users = loginDao.getAll();
        for(loginData user : users){
            if(user.getDataEmail().equals(check)){
                if(user.getDataPass().equals(checkPass)){
                    return true;
                }
            }
        }
        return false;
    }

    public static userRepository getRepository(Context context) {
        if (INSTANCE == null) {
            synchronized (userRepository.class) {
                if (INSTANCE == null)
                    INSTANCE = new userRepository();
                    INSTANCE.context = context;
                    INSTANCE.loginDao = LoginDatabase.getDatabase(context).loginDataDao();

            }
        }
        return INSTANCE;
    }
}
