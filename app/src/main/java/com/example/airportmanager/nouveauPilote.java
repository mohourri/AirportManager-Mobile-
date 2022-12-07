package com.example.airportmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.airportmanager.classes.Avion;
import com.example.airportmanager.classes.Pilote;

import java.util.ArrayList;

public class nouveauPilote extends AppCompatActivity {
    Button btn_ajouter_pilote;
    EditText z_ID_pilote, z_nom_pilote, z_prenom_pilote, z_age_pilote ,z_experience_pilote;
    DBManager DB ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_pilote);

        btn_ajouter_pilote = findViewById(R.id.btn_ajouter_pilote);
        z_ID_pilote = findViewById(R.id.z_ID_pilote);
        z_nom_pilote = findViewById(R.id.z_nom_pilote);
        z_prenom_pilote = findViewById(R.id.z_prenom_pilote);
        z_age_pilote = findViewById(R.id.z_age_pilote);
        z_experience_pilote = findViewById(R.id.z_experience_pilote);

        btn_ajouter_pilote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer ID = Integer.parseInt(z_ID_pilote.getText().toString())  ;
                String nom = z_nom_pilote.getText().toString();
                String prenom = z_prenom_pilote.getText().toString();
                Integer age = Integer.parseInt(z_age_pilote.getText().toString()) ;
                Integer experience = Integer.parseInt(z_experience_pilote.getText().toString());

                Pilote p = new Pilote(ID,nom,prenom,age, experience);
                DB = new DBManager(nouveauPilote.this, "DB.db",null,1);

                DB.ajouterPilote(p);

                Toast.makeText(nouveauPilote.this, prenom+" "+nom+" est ajouté avec succès", Toast.LENGTH_LONG).show();


            }
        });
    }
}