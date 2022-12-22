package com.example.formatif;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PersonneArrayAdapter  extends ArrayAdapter<Administratif> {

    private Context context;
    private ArrayList<Administratif> lp;
    private  int resource;

    public PersonneArrayAdapter(Context context, int resource, List<Administratif> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        lp = new ArrayList<Administratif>();
        lp = (ArrayList<Administratif>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        Button btnPlus,btnMoins, btnAdd;
        EditText txtCantite;
        Administratif ptemp = this.lp.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(this.resource,parent,false);


        TextView nom = (TextView) convertView.findViewById(R.id.txtNom);
        TextView txtBureau = (TextView) convertView.findViewById(R.id.txtBureau);
        TextView txtPoste = (TextView) convertView.findViewById(R.id.txtPoste);
        TextView txtDescription = (TextView) convertView.findViewById(R.id.txtDescription);
        TextView txtEmail = (TextView) convertView.findViewById(R.id.txtEmail);




        String detailleNom = ptemp.getNom() +" "+ ptemp.getPrenom();
        nom.setText(detailleNom);
        txtBureau.setText(ptemp.getBureau());
        txtPoste.setText(ptemp.getPoste());
        txtDescription.setText(ptemp.getDescription());
        txtEmail.setText(ptemp.getEmail());




        return  convertView;
    }

}
