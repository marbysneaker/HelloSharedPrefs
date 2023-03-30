package com.example.android.hellosharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    int mCount;
    int mColor;

    boolean isChecked;
    CheckBox remember;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        remember = findViewById(R.id.checkBox4);
        Bundle bundle = getIntent().getExtras();

         mCount = bundle.getInt("mcount");
         mColor = bundle.getInt("mcolor");



    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();


    }

    public void saveData(){

        if(remember.isChecked()){
            isChecked = true;
        }
        else{
            isChecked = false;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("mcount", mCount);
        editor.putInt("mcolor",mColor);
        editor.putBoolean("isChecked", isChecked);
        editor.commit();
        Toast.makeText(this, "data is saved", Toast.LENGTH_SHORT).show();
    }
}