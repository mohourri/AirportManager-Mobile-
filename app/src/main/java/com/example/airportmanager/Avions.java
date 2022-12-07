package com.example.airportmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.airportmanager.Adapters.Adapter_avions;
import com.example.airportmanager.classes.Avion;
import com.example.airportmanager.classes.Pilote;
import com.example.airportmanager.interfaces.RecyclerViewInterface;

import java.util.ArrayList;

public class Avions extends AppCompatActivity implements RecyclerViewInterface {

    Button btn_nouveau_avion , btn_vider_avions;
    static RecyclerView rv ;
    ArrayList<Avion> avions = new ArrayList<>();

    DBManager DB = new DBManager(this, "DB.db",null,1);
    Adapter_avions adaptateur = new Adapter_avions(this,avions, this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avions);
        // Instanciation

        btn_nouveau_avion = findViewById(R.id.btn_nouveau_avion);
        btn_vider_avions = findViewById(R.id.btn_vider_avions);
        rv = findViewById(R.id.rv_pilotes);
        rv.setAdapter(adaptateur);
        rv.setLayoutManager(new LinearLayoutManager(this));


        btn_nouveau_avion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Avions.this, NouvelleAvion.class);
                startActivity(i);

            }
        });

        btn_vider_avions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB.viderAvions();
                loadAvions();
                if(avions.size()==0 )
                    Toast.makeText(Avions.this, "Tout est supprimé", Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadAvions();
    }

    public void loadAvions(){
        avions.clear();
        avions.addAll(DB.loadAvions());
        adaptateur.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Avion p = new Avion();
        p = avions.get(position);
        Intent i = new Intent(Avions.this, consult_avion.class);
        i.putExtra("avion",p);
        startActivity(i);
    }
}