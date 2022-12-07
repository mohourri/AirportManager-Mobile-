package com.example.airportmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.airportmanager.Adapters.Adapter_pilotes;
import com.example.airportmanager.classes.Pilote;
import com.example.airportmanager.interfaces.RecyclerViewInterface;

import java.util.ArrayList;

public class Pilotes extends AppCompatActivity implements RecyclerViewInterface {

    Button btn_nouveau_pilote, btn_vider_pilotes;
    RecyclerView rv;
    ArrayList<Pilote> pilotes = new ArrayList<Pilote>();
    DBManager DB = new DBManager(this, "DB.db",null,1);
    Adapter_pilotes adaptateur = new Adapter_pilotes(this, pilotes, this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilotes);

        btn_vider_pilotes = findViewById(R.id.btn_vider_pilotes);
        btn_nouveau_pilote = findViewById(R.id.btn_nouveau_pilote);

        rv = findViewById(R.id.rv_pilotes);
        loadPilotes();

        btn_nouveau_pilote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Pilotes.this,nouveauPilote.class);
                startActivity(i);
            }
        });

        btn_vider_pilotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pilotes.addAll(DB.viderPilotes());
                loadPilotes();
                adaptateur.notifyDataSetChanged();
                Toast.makeText(Pilotes.this, "La liste a été vidée", Toast.LENGTH_SHORT).show();
            }
        });

        rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick(view.getVerticalScrollbarPosition());
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        loadPilotes();
    }

    public void loadPilotes(){
        pilotes.clear();
        pilotes.addAll(DB.loadPilotes());
        adaptateur.notifyDataSetChanged();
        rv.setAdapter(adaptateur);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {
        Pilote p = new Pilote();
        p = pilotes.get(position);
        Intent i = new Intent(Pilotes.this, consult_pilote.class);
        i.putExtra("pilote",p);
        startActivity(i);
    }
}