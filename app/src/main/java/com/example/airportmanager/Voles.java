package com.example.airportmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.airportmanager.Adapters.Adapter_voles;
import com.example.airportmanager.classes.Pilote;
import com.example.airportmanager.classes.Vole;
import com.example.airportmanager.interfaces.RecyclerViewInterface;

import java.util.ArrayList;

public class Voles extends AppCompatActivity implements RecyclerViewInterface {

    Button btn_nouveau_vole;
    RecyclerView rv;
    ArrayList<Vole> voles;
    Adapter_voles adaptateur;
    DBManager DB = new DBManager(this, "DB.db",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voles);

        btn_nouveau_vole = findViewById(R.id.btn_nouveau_vole);
        rv = findViewById(R.id.rv);
        voles = new ArrayList<>();
        adaptateur = new Adapter_voles(this, voles, this);
        rv.setAdapter(adaptateur);
        rv.setLayoutManager(new LinearLayoutManager(this));

        btn_nouveau_vole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Voles.this, NouveauVole.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadVoles();
    }

    public void loadVoles(){
        voles.clear();
        voles.addAll(DB.loadVoles());
        adaptateur.notifyDataSetChanged();
        Toast.makeText(this, "vient d'actualiser", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(int position) {
        Vole p = new Vole();
        p = voles.get(position);
        Intent i = new Intent(Voles.this, consult_vole.class);
        i.putExtra("vole",p);
        startActivity(i);
    }
}