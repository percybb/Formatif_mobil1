package com.example.formatif;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Creer extends AppCompatActivity {

    private TextView lblUno,lblDos,lblTres;
    private EditText txtNom,txtPrenom,txtBureau, txtUno,txtDos,txtTres;
    private Button btnEnvoyer;
    public String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer);

        this.lblUno = (TextView) findViewById(R.id.lblUno);
        this.lblDos=(TextView) findViewById(R.id.lblDos);


        this.txtNom=(EditText) findViewById(R.id.txtNom);
        this.txtPrenom=(EditText) findViewById(R.id.txtPrenom);
        this.txtBureau=(EditText) findViewById(R.id.txtBureau);
        this.txtUno=(EditText) findViewById(R.id.txtUno);
        this.txtDos=(EditText) findViewById(R.id.txtDos);
        this.txtTres=(EditText) findViewById(R.id.txtTres);
        this.btnEnvoyer=(Button)findViewById(R.id.btnEnvoyer);
        type="admin";
        lblUno.setText("Poste:");
        lblDos.setText("Description de poste:");


        btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbWorker2 dbw = new dbWorker2(Creer.this);
                dbw.execute(type,txtNom.getText().toString(),txtPrenom.getText().toString(),txtBureau.getText().toString(),txtUno.getText().toString(),txtDos.getText().toString(),txtTres.getText().toString());


                try {
                    Object line;
                    line = dbw.get();
                    String line2 = line.toString();
                    if(line2.contains("ok1")){
                        Toast.makeText(Creer.this,"Enregistrement administratif ok!", Toast.LENGTH_SHORT).show();
                        txtNom.setText("");
                        txtPrenom.setText("");
                        txtBureau.setText("");
                        txtUno.setText("");
                        txtDos.setText("");
                        txtTres.setText("");
                    }
                    else if(line2.contains("ok2")){
                        Toast.makeText(Creer.this,"Enregistrement enseignant ok!", Toast.LENGTH_SHORT).show();
                        txtNom.setText("");
                        txtPrenom.setText("");
                        txtBureau.setText("");
                        txtUno.setText("");
                        txtDos.setText("");
                        txtTres.setText("");
                    }
                    else{
                        Toast.makeText(Creer.this,"Enregistrement a échoué !", Toast.LENGTH_SHORT).show();
                    }

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //   String line2 = line.toString();
                   // Toast.makeText(Creer.this,line2, Toast.LENGTH_SHORT).show();
      /*              if(line2.contains("ok")){
                      //  Toast.makeText(getApplicationContext(),line2, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),line2, Toast.LENGTH_SHORT).show();
                    }*/





            }
        });
    }


    public void OnRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch(view.getId()){
            case R.id.radAdmin:
                if(checked)
                {
                   type="admin";
                   lblUno.setText("Poste:");
                   lblDos.setText("Description de poste:");

                  //  Toast.makeText(MainActivity.this,"fruta",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.radEnseg:
                if(checked)
                {
                    type="enseig";
                    lblUno.setText("Departement:");
                    lblDos.setText("Status:");
                  //  Toast.makeText(MainActivity.this,"viande",Toast.LENGTH_SHORT).show();
                }
                break;


        }
    }


}