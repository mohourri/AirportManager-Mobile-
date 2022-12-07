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
import com.example.airportmanager.interfaces.RecyclerViewInterface;

import java.util.ArrayList;

public class Adapter_avions extends RecyclerView.Adapter<Adapter_avions.Container> {
    private static RecyclerViewInterface recyclerViewInterface;
    Context c;
    ArrayList<Avion> avions ;

    public Adapter_avions(Context c, ArrayList<Avion> avs,  RecyclerViewInterface recyclerViewInterface) {
        this.c = c;
        this.avions = avs;
        this.recyclerViewInterface =recyclerViewInterface;
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
        holder.nom_avion.setText(avions.get(position).getNom());
        holder.capacite_avion.setText(""+avions.get(position).getCapacite());
        holder.entreprise_avion.setText(avions.get(position).getEntreprise());
    }

    @Override
    public int getItemCount() {
        return avions.size();
    }

    public class Container extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nom_avion, capacite_avion , entreprise_avion;

        public Container(@NonNull View itemView) {
            super(itemView);
            this.nom_avion = itemView.findViewById(R.id.case_nom);
            this.capacite_avion = itemView.findViewById(R.id.case_capacite);
            this.entreprise_avion = itemView.findViewById(R.id.case_entreprise);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {

        }
    }
}
