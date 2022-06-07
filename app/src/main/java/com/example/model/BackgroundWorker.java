package com.example.model;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String,Void,String> {

    Context context;
    ProgressDialog loading;
    BackgroundWorker (Context ctx){
        context = ctx;
    }

    @Override
    protected String doInBackground(String... voids) {
        String type = voids[0];
        String login_url = "http://uxoricidal-image.000webhostapp.com/getEmp.php";
        String register_url = "http://uxoricidal-image.000webhostapp.com/addEmp.php";
        String read_rul = "http://uxoricidal-image.000webhostapp.com/view.php";


        if (type.equals("login")){
            try {
                String username = voids[1];
                String password = voids[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while ((line = bufferedReader.readLine())!=null) {
                    result += line;
                }
                if (result.equals("Login successfully")){
                    Intent intent = new Intent(context.getApplicationContext(), Home.class);
                    intent.putExtra("us",username.toString());
                    context.startActivity(intent);
                    SharedPreferences sp=context.getSharedPreferences("credentials",context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("username",username.toString());
                    editor.commit();
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (type.equals("register")){
            try {
                String bs = voids[1];
                String name = voids[2];
                String username = voids[3];
                String password = voids[4];
                String age = voids[5];
                String email = voids[6];
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("bs","UTF-8")+"="+URLEncoder.encode(bs,"UTF-8")+"&"
                        +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                        +URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                        +URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8")+"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while ((line = bufferedReader.readLine())!=null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                if (result.equals("Registration Succesful")){
                    Intent intent = new Intent(context.getApplicationContext(), Home.class);
                    intent.putExtra("us",username.toString());
                    context.startActivity(intent);
                    SharedPreferences sp=context.getSharedPreferences("credentials",context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("username",username.toString());
                    editor.putString("name",username.toString());
                    editor.putString("age",username.toString());
                    editor.putString("email",username.toString());
                    editor.putString("bs",username.toString());
                    editor.commit();
                }
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type.equals("read")) {
            try {
                URL url = new URL(read_rul);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            return null;
    }

    @Override
    protected void onPreExecute() {

        loading = ProgressDialog.show(context, "Fetching...","Wait...",false,false);

    }

    @Override
    protected void onPostExecute(String result) {
        loading.dismiss();
        if (result.equals("Login error")||result.equals("Registration Succesful")){
            if (result.equals("Registration Succesful")){
                Toast.makeText(context.getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context.getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        } else {
            if (result.equals("Login successfully")) {
                Toast.makeText(context.getApplicationContext(), result, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context.getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
