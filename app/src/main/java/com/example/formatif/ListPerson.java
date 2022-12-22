package com.example.formatif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ListPerson extends AppCompatActivity {
    ListView lstPersonne;
    ArrayList<Administratif> PersonneArrayList = new ArrayList<Administratif>();
    ArrayList<Enseignant> EnseignantArrayList = new ArrayList<Enseignant>();

    TextView lblTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_person);

        String titre = getIntent().getExtras().getString("titre");
        String msg = "List de "+titre;
        Log.i("msg 1: ",titre);
        Log.i("msg 2: ",msg);
        this.lblTitle = (TextView) findViewById(R.id.lblTitle);
        this.lstPersonne = (ListView) findViewById(R.id.lstPersonnes);

        lblTitle.setText(msg);

        final PersonneArrayAdapter adapter = new PersonneArrayAdapter(this,R.layout.listpersonnes,PersonneArrayList);
        final EnseignantArrayAdapter adapter2 = new EnseignantArrayAdapter(this,R.layout.listenseignant,EnseignantArrayList);

        lblTitle.setText(titre);
        String temp="";
        String lstP;
        int nb;
        if(titre.equals("administrateurs"))
        {
            try {

                lstP = lstProduit("administrateurs");
               // Toast.makeText(this,lstP,Toast.LENGTH_SHORT).show();

                if(lstP.contains("vide"))
                {
                    Toast.makeText(this,"Pas encore de produit", Toast.LENGTH_LONG).show();
                }
                else{
                     nb = Integer.parseInt(lstP.substring(0,lstP.indexOf('#'))); //.indexOf('#');
                    temp = lstP.substring(lstP.indexOf('#')+1);

                    String[] item = new String[11];
                    for (int i=0; i<nb; i++ )
                    {
                        for(int j=0;j<7;j++){

                            item[j]=temp.substring(0,temp.indexOf('#'));;
                            Log.i("item",item[j] );
                            temp=temp.substring(temp.indexOf('#')+1);
                        }
                        int nbv=0;
                        PersonneArrayList.add(new Administratif(Integer.parseInt(item[0]),item[1],item[2],item[3],item[4],item[5],item[6]));
                    }

                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.lstPersonne.setAdapter(adapter);
        }
        else if(titre.equals("enseignant"))
        {
            try {

                 lstP = lstProduit("enseignant");
               // Toast.makeText(this,lstP,Toast.LENGTH_SHORT).show();

                if(lstP.contains("vide"))
                {
                    Toast.makeText(this,"Pas encore de produit", Toast.LENGTH_LONG).show();
                }
                else{
                     nb = Integer.parseInt(lstP.substring(0,lstP.indexOf('#'))); //.indexOf('#');
                    temp = lstP.substring(lstP.indexOf('#')+1);

                    String[] item1 = new String[11];
                    for (int i=0; i<nb; i++ )
                    {
                        for(int j=0;j<7;j++){

                            item1[j]=temp.substring(0,temp.indexOf('#'));;
                            Log.i("item",item1[j] );
                            temp=temp.substring(temp.indexOf('#')+1);
                        }
                        int nbv=0;
                        EnseignantArrayList.add(new Enseignant(Integer.parseInt(item1[0]),item1[1],item1[2],item1[3],item1[4],item1[5],item1[6]));
                    }

                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.lstPersonne.setAdapter(adapter2);
        }


        //produitArrayList.add(new Produit(12,"SOLE","banana","unite",2.30,3.00,3.00,"--"));
        //produitArrayList.add(new Produit(12,"SOLE","banana","unite",2.30,3.00,3.00,"--"));




        this.lstPersonne.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = PersonneArrayList.get(i).getId();
                pasar(id);
                return false;
            }
        });
    }

    public void pasar(int id)
    {
        Intent act2;
        act2 = new Intent(this,personne.class);
        act2.putExtra("id",id);
        startActivity(act2);
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