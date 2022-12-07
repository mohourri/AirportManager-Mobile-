package com.example.airportmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.airportmanager.classes.Avion;
import com.example.airportmanager.classes.Pilote;

public class consult_avion extends AppCompatActivity {
    Button btn_modifier, btn_supprimer;
    EditText ID, nom, capacite, entreprise;
    static Avion p = new Avion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_avion);

        p = (Avion) getIntent().getSerializableExtra("avion");


        DBManager DB = new DBManager(this, "DB.db",null,1);

        btn_modifier= findViewById(R.id.btn_modifier_avion);
        btn_supprimer =  findViewById(R.id.btn_supprimer_avion);

        ID =  findViewById(R.id.et_ID_avion);
        nom =  findViewById(R.id.et_nom_avion);
        capacite =  findViewById(R.id.et_capacite_avion);
        entreprise =  findViewById(R.id.et_entreprise_avion);



        ID.setText(p.getID()+"");
        nom.setText(p.getNom());
        capacite.setText(p.getCapacite()+"");
        entreprise.setText(p.getEntreprise());

        btn_modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Avion p = new Avion(
                        Integer.parseInt(ID.getText().toString()),
                        nom.getText().toString(),
                        Integer.parseInt(capacite.getText().toString()),
                        entreprise.getText().toString()
                );

                DB.modifierAvion(p);
                Toast.makeText(consult_avion.this, "modifié avec succès", Toast.LENGTH_SHORT).show();

            }
        });

        btn_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res = DB.supprimerAvion(p.getID());
                if(res)
                    Toast.makeText(consult_avion.this, "supprimé avec succès", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    public void showPiloteInfos(Pilote p){
        Toast.makeText(this, "pilote "+p.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Intent getIntent() {
        return super.getIntent();
    }
}