package com.example.model;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Nutrients extends AppCompatActivity implements View.OnClickListener {
    private TextView tvid,tvna,tva,tvb,tvc,tvd,tve,tvf,tvg,tvh,tvi,tvj,tvk,
            tvl,tvm,tvn,tvo,tvp,tvq,tvr,tvs,tvt,tvu,tvv,tvw,tvx,tvy,tvz,
            tvaa,tvab,tvac,tvad,tvae,tvaf,tvag,tvah,tvai,tvaj,tvak,
            tval,tvam,tvan,tvao,tvap,tvaq,tvar,tvas,tvat,tvau,tvav,tvaw,tvax,tvay;
    private String id;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrients);

        Intent i = getIntent();
        id = i.getStringExtra(Config.EMP_ID);
        tvid = findViewById(R.id.nid);
        back = findViewById(R.id.nback);
        tvna = findViewById(R.id.nname);
        tva = findViewById(R.id.a);tvb = findViewById(R.id.b);tvc = findViewById(R.id.c);
        tvd = findViewById(R.id.d);tve = findViewById(R.id.e);tvf = findViewById(R.id.f);
        tvg = findViewById(R.id.g);tvh = findViewById(R.id.h);tvi = findViewById(R.id.i);
        tvj = findViewById(R.id.j);tvk = findViewById(R.id.k);tvl = findViewById(R.id.l);
        tvm = findViewById(R.id.m);tvn = findViewById(R.id.n);tvo = findViewById(R.id.o);
        tvp = findViewById(R.id.p);tvq = findViewById(R.id.q);tvr = findViewById(R.id.r);
        tvs = findViewById(R.id.s);tvt = findViewById(R.id.t);tvu = findViewById(R.id.u);
        tvv = findViewById(R.id.v);tvw = findViewById(R.id.w);tvx = findViewById(R.id.x);
        tvy = findViewById(R.id.y);tvz = findViewById(R.id.z);
        tvaa = findViewById(R.id.aa);tvaj = findViewById(R.id.aj);tvar = findViewById(R.id.ar);
        tvab = findViewById(R.id.ab);tvak = findViewById(R.id.ak);tvas = findViewById(R.id.as);
        tvac = findViewById(R.id.ac);tval = findViewById(R.id.al);tvat = findViewById(R.id.at);
        tvad = findViewById(R.id.ad);tvam = findViewById(R.id.am);tvau = findViewById(R.id.au);
        tvae = findViewById(R.id.ae);tvan = findViewById(R.id.an);tvav = findViewById(R.id.av);
        tvaf = findViewById(R.id.af);tvao = findViewById(R.id.ao);tvaw = findViewById(R.id.aw);
        tvag = findViewById(R.id.ag);tvap = findViewById(R.id.ap);tvax = findViewById(R.id.ax);
        tvah = findViewById(R.id.ah);tvaq = findViewById(R.id.aq);tvay = findViewById(R.id.ay);
        tvai = findViewById(R.id.ai);

        tvid.setText(id);
        back.setOnClickListener(this);

        getEmployee();
    }

    private void getEmployee() {
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Nutrients.this,"Fetching...","Wait...",false,false);
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
                String s = rh.sendGetRequestParam(Config.URL_GET_EMP,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String name = c.getString("name");
            String a = c.getString("a");
            String b = c.getString("b");
            String cc = c.getString("c");
            String d = c.getString("d");
            String e = c.getString("e");
            String f = c.getString("f");
            String g = c.getString("g");
            String h = c.getString("h");
            String ii = c.getString("i");
            String j = c.getString("j");
            String k = c.getString("k");
            String l = c.getString("l");
            String m = c.getString("m");
            String n = c.getString("n");
            String o = c.getString("o");
            String p = c.getString("p");
            String q = c.getString("q");
            String r = c.getString("r");
            String s= c.getString("s");
            String t = c.getString("t");
            String u = c.getString("u");
            String v = c.getString("v");
            String w = c.getString("w");
            String x = c.getString("x");
            String y = c.getString("y");
            String z = c.getString("z");
            String aa = c.getString("aa");
            String ab = c.getString("ab");
            String ac= c.getString("ac");
            String ad = c.getString("ad");
            String ae = c.getString("ae");
            String af = c.getString("af");
            String ag = c.getString("ag");
            String ah = c.getString("ah");
            String ai = c.getString("ai");
            String aj = c.getString("aj");
            String ak = c.getString("ak");
            String al = c.getString("al");
            String am= c.getString("am");
            String an = c.getString("an");
            String ao = c.getString("ao");
            String ap = c.getString("ap");
            String aq = c.getString("aq");
            String ar = c.getString("ar");
            String as = c.getString("as");
            String at = c.getString("at");
            String au = c.getString("au");
            String av = c.getString("av");
            String aw= c.getString("aw");
            String ax = c.getString("ax");
            String ay= c.getString("ay");

            tvna.setText(name);
            tva.setText(a);tvh.setText(h);tvo.setText(o);tvu.setText(u);
            tvb.setText(b);tvi.setText(ii);tvp.setText(p);tvv.setText(v);
            tvc.setText(cc);tvj.setText(j);tvq.setText(q);tvw.setText(w);
            tvd.setText(d);tvk.setText(k);tvr.setText(r);tvx.setText(x);
            tve.setText(e);tvl.setText(l);tvs.setText(s);tvy.setText(y);
            tvf.setText(f);tvm.setText(m);tvt.setText(t);tvz.setText(z);
            tvg.setText(g);tvn.setText(n);
            tvaa.setText(aa);tvah.setText(ah);tvan.setText(an);tvat.setText(at);
            tvab.setText(ab);tvai.setText(ai);tvao.setText(ao);tvau.setText(au);
            tvac.setText(ac);tvaj.setText(aj);tvap.setText(ap);tvav.setText(av);
            tvad.setText(ad);tvak.setText(ak);tvaq.setText(aq);tvaw.setText(aw);
            tvae.setText(ae);tval.setText(al);tvar.setText(ar);tvax.setText(ax);
            tvaf.setText(af);tvam.setText(am);tvas.setText(as);tvay.setText(ay);
            tvag.setText(ag);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        onBackPressed();
    }
}