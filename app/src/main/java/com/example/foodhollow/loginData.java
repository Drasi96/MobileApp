package com.example.foodhollow;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "loginData")
public class loginData {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "dataName")
    private String dataName;

    public loginData(String dataName, String dataEmail, String dataPass) {
        this.dataName = dataName;
        this.dataEmail = dataEmail;
        this.dataPass = dataPass;
    }

    @ColumnInfo(name = "dataEmail")
    private String dataEmail;
    @ColumnInfo(name = "dataPass")
    private String dataPass;
   /* @ColumnInfo(name = "dataImage")
    private  byte[] dataImage;*/





    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }


    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataEmail() {
        return dataEmail;
    }

    public void setDataEmail(String dataEmail) {
        this.dataEmail = dataEmail;
    }

    public String getDataPass() {
        return dataPass;
    }

    public void setDataPass(String dataPass) {
        this.dataPass = dataPass;
    }

  /*  public byte[] getDataImage() {
        return dataImage;
    }

    public void setDataImage(byte[] dataImage) {
        this.dataImage = dataImage;
    }
*/

}
