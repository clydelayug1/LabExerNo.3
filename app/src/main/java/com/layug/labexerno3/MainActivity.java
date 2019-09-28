package com.layug.labexerno3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText input, ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.editText);
    }

    public void saveData(View v){
        String data = input.getText().toString();
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(data.getBytes());
        } catch (FileNotFoundException e){
            Log.d("error", "School not found...");
        } catch (IOException e) {
            Log.d("error", "IO Error...");
        } finally {
            try {
                writer.close();
            } catch (IOException e){
                Log.d("error", "IO Error...");
            }
            Toast.makeText(this, "School saved...", Toast.LENGTH_LONG).show();
        }
    }

    public void next(View v){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);

    }
}
