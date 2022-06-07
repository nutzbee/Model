package com.example.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    EditText bs,name,username,password,age,email;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bs = findViewById(R.id.rbs);
        name = findViewById(R.id.rname);
        username = findViewById(R.id.rusername);
        password = findViewById(R.id.rpassword);
        age = findViewById(R.id.rage);
        email = findViewById(R.id.remail);
        btn = findViewById(R.id.rsignup);
        tv = findViewById(R.id.slogin);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_bs = bs.getText().toString();
                String str_name = name.getText().toString();
                String str_username = username.getText().toString();
                String str_password = password.getText().toString();
                String str_age = age.getText().toString();
                String str_email = email.getText().toString();
                String type = "register";

                BackgroundWorker backgroundWorker = new BackgroundWorker(Register.this);
                backgroundWorker.execute(type, str_bs, str_name, str_username, str_password,
                        str_age, str_email);
            }
        });

    }
}