package com.example.model;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText us,pw;
    Button btn;
    TextView tvRegister;
    ProgressDialog progressDialog;

    public static final String user = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        us = findViewById(R.id.username);
        pw = findViewById(R.id.password);
        btn = findViewById(R.id.login);
        tvRegister = findViewById(R.id.signup);

        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        if (sp.contains(user)){
            Intent i = new Intent(MainActivity.this, Home.class);
            startActivity(i);
        }
        if(sp.contains("msg"))
        {
            Toast.makeText(this, sp.getString("msg", ""), Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor ed=sp.edit();
            ed.remove("msg");
            ed.commit();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = us.getText().toString();
                String password = pw.getText().toString();
                String type = "login";

                BackgroundWorker backgroundWorker = new BackgroundWorker(MainActivity.this);
                backgroundWorker.execute(type, username, password);
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(getApplicationContext(), Register.class);
                startActivity(next);
            }
        });
    }

}