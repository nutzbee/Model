package com.example.model;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Home extends AppCompatActivity implements View.OnClickListener {

    TextView name,age,email,bs,us;
    Button save,cancel;
    private String uss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name = findViewById(R.id.hname);
        age = findViewById(R.id.hage);
        email = findViewById(R.id.hemail);
        bs = findViewById(R.id.hbs);
        save = findViewById(R.id.hsave);
        cancel = findViewById(R.id.hcancel);
        us = findViewById(R.id.husername);

        Intent i = getIntent();
        uss = i.getStringExtra("us");
        us.setText(uss);
        getEmployee();

        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("username")||sp.contains("name")||sp.contains("email")||sp.contains("age")||sp.contains("bs")) {
            us.setText(sp.getString("username", ""));
            name.setText(sp.getString("name", ""));
            age.setText(sp.getString("age", ""));
            email.setText(sp.getString("email", ""));
            bs.setText(sp.getString("bs", ""));
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(getApplicationContext(), Meal.class);
                startActivity(next);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                if(sp.contains("username"))
                {
                    SharedPreferences.Editor editor=sp.edit();
                    editor.remove("username");

                    editor.putString("msg","Logged out Successfully");
                    editor.commit();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
            }
        });


    }

    private void getEmployee() {
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Home.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Config.URL_GET_USER,uss);
                return s;
            }
        }

        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String n = c.getString("name");
            String a = c.getString("age");
            String e = c.getString("email");
            String b = c.getString("blood_sugar");

            name.setText(n);
            age.setText(a);
            email.setText(e);
            bs.setText(b);


        } catch (JSONException e) {
                e.printStackTrace();
            }
    }


    @Override
    public void onClick(View view) {
    }
}