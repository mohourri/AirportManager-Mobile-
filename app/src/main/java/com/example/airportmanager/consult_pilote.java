package com.example.airportmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.airportmanager.classes.Pilote;

public class consult_pilote extends AppCompatActivity {
    Button btn_modifier, btn_supprimer;
    EditText ID, nom, prenom, age, experience;
    static Pilote p = new Pilote();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_pilote);

        p = (Pilote) getIntent().getSerializableExtra("pilote");


        DBManager DB = new DBManager(this, "DB.db",null,1);

        btn_modifier= findViewById(R.id.btn_modifier_pilote);
        btn_supprimer =  findViewById(R.id.btn_supprimer_pilote);

        ID =  findViewById(R.id.et_ID_pilote);
        nom =  findViewById(R.id.et_nom_pilote);
        prenom =  findViewById(R.id.et_capacite_pilote);
        age =  findViewById(R.id.et_entreprise_pilote);
        experience =  findViewById(R.id.et_experience_pilote);



        ID.setText(p.getID()+"");
        nom.setText(p.getNom());
        prenom.setText(p.getPrenom());
        age.setText(p.getAge()+"");
        experience.setText(p.getExperience()+"");

        btn_modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pilote p = new Pilote(
                        Integer.parseInt(ID.getText().toString()),
                        nom.getText().toString(),
                        prenom.getText().toString(),
                        Integer.parseInt(age.getText().toString()),
                        Integer.parseInt(experience.getText().toString())
                );

                DB.modifierPilote(p);
                Toast.makeText(consult_pilote.this, "modifié avec succès", Toast.LENGTH_SHORT).show();

            }
        });

        btn_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res = DB.supprimerPilote(p.getID());
                if(res)
                    Toast.makeText(consult_pilote.this, "supprimé avec succès", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }


    @Override
    public Intent getIntent() {
        return super.getIntent();
    }
}