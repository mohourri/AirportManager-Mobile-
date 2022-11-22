package com.example.airportmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_avions, btn_voles, btn_pilotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_voles = findViewById(R.id.btn_voles);
        btn_avions = findViewById(R.id.btn_avions);
        btn_pilotes = findViewById(R.id.btn_pilotes);

        btn_avions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Avions.class);
                startActivity(i);
            }
        });

        btn_pilotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Pilotes.class);
                startActivity(i);
            }
        });

        btn_voles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Voles.class);
                startActivity(i);
            }
        });

    }
}