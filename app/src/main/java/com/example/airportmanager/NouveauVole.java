package com.example.airportmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.airportmanager.Adapters.Adapter_voles;
import com.example.airportmanager.classes.Avion;
import com.example.airportmanager.classes.Pilote;
import com.example.airportmanager.classes.Vole;

import java.sql.Date;
import java.util.ArrayList;

public class NouveauVole extends AppCompatActivity {

    EditText z_ID_vole, z_date_vole, z_depart, z_destination ;
    Spinner spinner_avion, spinner_pilote;
    Button btn_ajouter_vole;
    DBManager DB =new DBManager(NouveauVole.this, "DB.db",null,1);
    ArrayList<String> avs = new ArrayList<>();
    ArrayList<String> plts = new ArrayList<>();

    ArrayAdapter adapterAvions ;
    ArrayAdapter adapterPilotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_vole);
        btn_ajouter_vole = findViewById(R.id.ajouter_vole);
        z_ID_vole =findViewById(R.id.z_ID_vole);
        z_date_vole =findViewById(R.id.z_date_vole);
        z_depart =findViewById(R.id.z_depart);
        z_destination =findViewById(R.id.z_destination);

        spinner_avion = findViewById(R.id.spinner_nom_avion);
        spinner_pilote = findViewById(R.id.spinner_nom_pilote);

        btn_ajouter_vole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Vole v = new Vole(
                        Integer.parseInt(z_ID_vole.getText().toString()),
                        z_depart.getText().toString(),
                        z_destination.getText().toString(),
                        z_date_vole.getText().toString(),
                        spinner_pilote.getSelectedItem().toString(),
                        spinner_avion.getSelectedItem().toString()
                );

                DB.ajouterVole(v);

                Toast.makeText(NouveauVole.this, z_depart.getText().toString()+"-> "+z_destination.getText().toString()+" est ajouté avec succès", Toast.LENGTH_LONG).show();

            }
        });
        chargerSpinners();
    }

    public void chargerSpinners(){

        for (Avion a: DB.loadAvions()) {
            avs.add(a.getNom());
        }
        for (Pilote a: DB.loadPilotes()) {
            plts.add(a.getNom()+" "+a.getPrenom());
        }

        adapterPilotes = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, plts);
        adapterAvions = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, avs);
        spinner_pilote.setAdapter(adapterPilotes);
        spinner_avion.setAdapter(adapterAvions);

        adapterAvions.notifyDataSetChanged();
        adapterPilotes.notifyDataSetChanged();

    }
}