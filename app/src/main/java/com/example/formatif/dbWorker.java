package com.example.formatif;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class dbWorker extends AsyncTask {
    private Context c;
    private AlertDialog ad;
    public String msg;
    public dbWorker(Context c) {
        this.c = c;
    }

    @Override
    protected void onPreExecute() {
        this.ad = new AlertDialog.Builder(this.c).create();
        this.ad.setTitle("Login status");


    }

    @Override
    protected Object doInBackground(Object[] param) {
        Log.i("LLego aqui","si");
        //String cible = "http://192.168.0.154/comerce/formatif_mobil1/listAdmin.php";
        String cible = "https://ageeit-android.000webhostapp.com/formatif1/listAdmin.php";
        //String cible = "https://ageeit-android.000webhostapp.com/lstProd.php";

        try{
            URL url = new URL(cible);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            OutputStream outs = con.getOutputStream();
            BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(outs,"utf-8"));
            String msg = URLEncoder.encode("titre","utf-8")+"="+
                    URLEncoder.encode((String)param[0],"utf-8")
                    ;
            bufw.write(msg);
            bufw.flush();
            bufw.close();
            outs.close();

            InputStream ins = con.getInputStream();
            BufferedReader bufr = new BufferedReader(new InputStreamReader(ins,"iso-8859-1"));
            String line;
            StringBuffer sbuff = new StringBuffer();
            while((line = bufr.readLine())!=null)
            {
                sbuff.append(line+"\n");

            }
            Log.i("paso aqui","si");
            return sbuff.toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        this.ad.setMessage((String)o);
        //this.ad.show();



    }
}
