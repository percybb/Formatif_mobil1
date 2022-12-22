package com.example.formatif;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class test extends AppCompatActivity {

    jouet titre;
    Button btnIr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        titre = (jouet) getIntent().getExtras().get("joue");
        Double val =  titre.getPrix();
        titre.setPrix(val*2);

        Toast.makeText(this, titre.getMarque()+" "+titre.getModele(), Toast.LENGTH_SHORT).show();

        this.btnIr = (Button)findViewById(R.id.btnIr);

        CoffreDeJouet cofre = new CoffreDeJouet();

        jouet j1 = new jouet("Toy","carro",2022,"esta bonito",120.00);
        jouet j2 = new jouet("Toy","carro",2022,"esta bonito",120.00);
        cofre.inserer(j1);
        cofre.inserer(j2);


        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent res = new Intent();
                res.putExtra("joue", titre);

                setResult(Activity.RESULT_OK,res);
                finish();
            }
        });




    }


}