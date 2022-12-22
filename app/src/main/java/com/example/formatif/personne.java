package com.example.formatif;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class personne extends AppCompatActivity {

    private TextView lblMsg;
    private TextView txtNom,txtPrenom,txtBureau,txtPoste,txtDescription,txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personne);

        this.txtNom = (TextView)findViewById(R.id.lblNom);
        this.txtPrenom = (TextView)findViewById(R.id.lblPrenom);
        this.txtBureau = (TextView)findViewById(R.id.lblBureau);

        this.lblMsg = (TextView)findViewById(R.id.txtMsg);
        int id = (int)getIntent().getExtras().getInt("id");
        String msg = "Profil :";
        this.lblMsg.setText(msg);

        String temp="";
        try {
            String req="lireUn"+String.valueOf(id);
            String lstP = lstProduit(req);
            //Toast.makeText(this,lstP,Toast.LENGTH_SHORT).show();

            if(lstP.contains("vide"))
            {
                Toast.makeText(this,"Pas encore de empploye", Toast.LENGTH_LONG).show();
            }
            else{
                int nb = Integer.parseInt(lstP.substring(0,lstP.indexOf('#'))); //.indexOf('#');
                temp = lstP.substring(lstP.indexOf('#')+1);

                String[] item = new String[11];
                for (int i=0; i<nb; i++ )
                {
                    for(int j=0;j<7 ;j++){

                        item[j]=temp.substring(0,temp.indexOf('#'));;
                        Log.i("item",item[j] );
                        temp=temp.substring(temp.indexOf('#')+1);
                    }
                    int nbv=0;
                   // PersonneArrayList.add(new Administratif(Integer.parseInt(item[0]),item[1],item[2],"","","",""));
                    this.txtNom.setText("Nom : "+item[0]);
                    this.txtPrenom.setText("Prenom : "+item[1]);
                    this.txtBureau.setText("Bureau : "+item[2]);

                }

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
        public String lstProduit(String titre) throws ExecutionException, InterruptedException {
            ArrayList<Administratif> lst = new ArrayList<Administratif>();
            dbWorker dbw = new dbWorker(this);
            dbw.execute(titre);
            Object line;
            line = dbw.get();
            String line2 = line.toString();
            return line2;
        }
}