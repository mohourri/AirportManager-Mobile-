package com.example.airportmanager;

import androidx.appcompat.app.AppCompatActivity;
import com.example.airportmanager.R;
import com.example.airportmanager.classes.Avion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class NouvelleAvion extends AppCompatActivity {
    Button btn_ajouter_avion;
    EditText z_ID_avion, z_nom_avion, z_capacite_avion, z_entreprise_avion;
    DBManager DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvelle_avion);
        btn_ajouter_avion = findViewById(R.id.btn_ajouter_avion);
        z_ID_avion = findViewById(R.id.z_ID_avion);
        z_nom_avion = findViewById(R.id.z_nom_avion);
        z_capacite_avion = findViewById(R.id.z_capacite_avion);
        z_entreprise_avion = findViewById(R.id.z_entreprise_avion);


        btn_ajouter_avion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer ID = Integer.parseInt(z_ID_avion.getText().toString())  ;
                String nom = z_nom_avion.getText().toString();
                Integer capacite = Integer.parseInt(z_capacite_avion.getText().toString()) ;
                String entreprise = z_entreprise_avion.getText().toString();

                Avion av = new Avion(ID,nom,capacite,entreprise);
                DB = new DBManager(NouvelleAvion.this, "DB.db",null,1);

                DB.ajouterAvion(av);

                Toast.makeText(NouvelleAvion.this, ID+": "+nom+" est ajouté avec succès", Toast.LENGTH_LONG).show();

            }

        });

    }


}