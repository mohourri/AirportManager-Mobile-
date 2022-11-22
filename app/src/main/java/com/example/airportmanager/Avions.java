package com.example.airportmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.airportmanager.Adapters.Adapter_avions;
import com.example.airportmanager.classes.Avion;

import java.util.ArrayList;

public class Avions extends AppCompatActivity {
//Theme.MaterialComponents.DayNight.DarkActionBar
    Button btn_nouveau_avion , btn_vider_avions;
    RecyclerView rv ;
    ArrayList<Avion> avions = new ArrayList<>();

    DBManager DB = new DBManager(this, "DB.db",null,1);
    Adapter_avions adaptateur = new Adapter_avions(this,avions);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avions);
        loadAvions();
        // Instanciation

        btn_nouveau_avion = findViewById(R.id.btn_nouveau_avion);
        btn_vider_avions = findViewById(R.id.btn_vider_avions);
        rv = findViewById(R.id.rv_avions);
        rv.setAdapter(adaptateur);

        btn_nouveau_avion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Avions.this, "HANA WLBANANA !!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Avions.this, NouvelleAvion.class);
                startActivity(i);

            }
        });
    }

    public void loadAvions(){
        avions.clear();
        avions.addAll(DB.loadAvions());
        adaptateur.notifyDataSetChanged();
    }
}