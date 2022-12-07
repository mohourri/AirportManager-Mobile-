package com.example.airportmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.airportmanager.classes.Avion;
import com.example.airportmanager.classes.Pilote;
import com.example.airportmanager.classes.Vole;

import java.util.ArrayList;

public class consult_vole extends AppCompatActivity {
    Button btn_modifier, btn_supprimer;
    EditText ID, depart, destination, date ;
    Spinner pilote, avion;
    static Vole p = new Vole();
    DBManager DB = new DBManager(this, "DB.db",null,1);

    ArrayList<String> plts = new ArrayList<>();
    ArrayList<String> avs = new ArrayList<>();

    ArrayAdapter adapterAvions ;
    ArrayAdapter adapterPilotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_vole);


        p = (Vole) getIntent().getSerializableExtra("vole");



        btn_modifier= findViewById(R.id.btn_modifier_vole);
        btn_supprimer =  findViewById(R.id.btn_supprimer_vole);

        ID =  findViewById(R.id.et_ID_vole);
        depart =  findViewById(R.id.et_depart_vole);
        destination =  findViewById(R.id.et_destination_vole);
        date =  findViewById(R.id.et_date);
        pilote =  findViewById(R.id.spinner_pilotes);
        avion =  findViewById(R.id.spinner_avions);



        ID.setText(p.getID()+"");
        depart.setText(p.getDepart());
        destination.setText(p.getDestination()+"");
        date.setText(p.getDate());
        pilote.setSelection(1);
        avion.setSelection(1);


        btn_modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vole p = new Vole(
                        Integer.parseInt(ID.getText().toString()),
                        depart.getText().toString(),
                        destination.getText().toString(),
                        date.getText().toString(),
                        pilote.getSelectedItem().toString(),
                        avion.getSelectedItem().toString()
                );

                DB.modifierVole(p);
                Toast.makeText(consult_vole.this, "modifié avec succès", Toast.LENGTH_SHORT).show();

            }
        });

        btn_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res = DB.supprimerVole(p.getID());
                if(res)
                    Toast.makeText(consult_vole.this, "supprimé avec succès", Toast.LENGTH_SHORT).show();
                finish();
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
        pilote.setAdapter(adapterPilotes);
        avion.setAdapter(adapterAvions);

        adapterAvions.notifyDataSetChanged();
        adapterPilotes.notifyDataSetChanged();

    }
}