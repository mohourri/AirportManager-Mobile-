package com.example.airportmanager.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airportmanager.R;
import com.example.airportmanager.classes.Avion;

import java.util.ArrayList;

public class Adapter_avions extends RecyclerView.Adapter<Adapter_avions.Container> {
    Context c;
    ArrayList<Avion> avions = new ArrayList<Avion>();

    public Adapter_avions(Context c, ArrayList<Avion> avions) {
        this.c = c;
        this.avions = avions;
    }

    @NonNull
    @Override
    public Adapter_avions.Container onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(c);
        View v = inflater.inflate(R.layout.item_avion, parent,false);
        return new Container(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_avions.Container holder, int position) {
        Avion av = avions.get(position);
        holder.nom_avion.setText(av.getNom());
        holder.capacite_avion.setText(av.getCapacite());
        holder.entreprise_avion.setText(av.getCapacite());
    }

    @Override
    public int getItemCount() {
        return avions.size();
    }

    public class Container extends RecyclerView.ViewHolder {
        TextView nom_avion, capacite_avion , entreprise_avion;

        public Container(@NonNull View itemView) {
            super(itemView);
            this.nom_avion = itemView.findViewById(R.id.case_nom);
            this.capacite_avion = itemView.findViewById(R.id.case_capacite);
            this.entreprise_avion = itemView.findViewById(R.id.case_entreprise);
        }
    }
}
