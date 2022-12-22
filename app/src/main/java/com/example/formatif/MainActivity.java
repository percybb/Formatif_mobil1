package com.example.formatif;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ListView lstPersonne;
    TextView lblTitre;
    Button btnAdmin,btnEnseignant,btnCreer;

    String option="administrateurs";


    private final int code=1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==code)
        {
            if(resultCode== Activity.RESULT_OK)
            {
                Bundle b= data.getExtras();
                jouet jou = (jouet) b.get("joue");
                Toast.makeText(this, jou.getMarque()+" "+ String.valueOf(jou.getPrix()), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        this.lblTitre = (TextView) findViewById(R.id.lblTitre);
        this.btnAdmin = (Button) findViewById(R.id.btnAdmin);
        this.btnEnseignant = (Button) findViewById(R.id.btnenseignant);
        this.btnCreer = (Button)findViewById(R.id.btnCreer);

        btnCreer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act3;
                act3 = new Intent(MainActivity.this,Creer.class);
                //jouet jugete = new jouet("Toy","carro",2022,"esta bonito",120.00);
                //act3.putExtra("joue",jugete);

                startActivity(act3);
                //startActivityForResult(act3,code);
            }
        });



        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasar("administrateurs");
            }
        });

        btnEnseignant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasar("enseignant");
            }
        });

    }

    public void pasar(String titre)
    {
        Intent act2;
        act2 = new Intent(this,ListPerson.class);
        act2.putExtra("titre",titre);
        startActivity(act2);
    }

}