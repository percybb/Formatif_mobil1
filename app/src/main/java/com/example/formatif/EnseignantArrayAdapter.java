package com.example.formatif;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class EnseignantArrayAdapter extends ArrayAdapter<Enseignant> {

    private Context context;
    private ArrayList<Enseignant> lp;
    private  int resource;

    public EnseignantArrayAdapter(Context context, int resource, List<Enseignant> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        lp = new ArrayList<Enseignant>();
        lp = (ArrayList<Enseignant>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Button btnPlus,btnMoins, btnAdd;
        EditText txtCantite;
        Enseignant ptemp = this.lp.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(this.resource,parent,false);

        TextView nom = (TextView) convertView.findViewById(R.id.txtNom);
        TextView txtBureau = (TextView) convertView.findViewById(R.id.txtBureau);
        TextView txtDepartement = (TextView) convertView.findViewById(R.id.txtDepartement);
        TextView txtStatus = (TextView) convertView.findViewById(R.id.txtStatus);
        TextView txtEmail = (TextView) convertView.findViewById(R.id.txtEmail);

        String detailleNom = ptemp.getNom() +" "+ ptemp.getPrenom();
        nom.setText(detailleNom);
        txtBureau.setText(ptemp.getBureau());
        txtDepartement.setText(ptemp.getDepartement());
        txtStatus.setText(ptemp.getStatus());
        txtEmail.setText(ptemp.getEmail());

        return  convertView;
    }

}
