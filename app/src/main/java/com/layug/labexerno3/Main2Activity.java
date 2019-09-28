package com.layug.labexerno3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void next(View v){
    StringBuffer msg = null;
        try {
        int token;
        msg = new StringBuffer();
        FileInputStream reader = openFileInput("data1.txt");
        while ((token=reader.read()) != -1){
            msg.append((char)token);
        }
    } catch (
    FileNotFoundException e){
        Log.d("error", "File not found..");
    } catch (
    IOException e) {
        Log.d("error", "IO error");
    }
        Toast.makeText(this, msg.toString(), Toast.LENGTH_SHORT).show();
}
}
