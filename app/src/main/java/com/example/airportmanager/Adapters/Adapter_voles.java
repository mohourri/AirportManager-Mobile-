package com.example.airportmanager.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airportmanager.R;
import com.example.airportmanager.classes.Vole;
import com.example.airportmanager.interfaces.RecyclerViewInterface;

import java.util.ArrayList;

public class Adapter_voles extends RecyclerView.Adapter<Adapter_voles.Container> {
    private static RecyclerViewInterface recyclerViewInterface;
    Context c;
    ArrayList<Vole> voles;

    public Adapter_voles(Context c, ArrayList<Vole> voles, RecyclerViewInterface recyclerViewInterface) {
        this.c = c;
        this.voles = voles;
        this.recyclerViewInterface= recyclerViewInterface;
    }

    @NonNull
    @Override
    public Adapter_voles.Container onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(c);
        View v = inflater.inflate(R.layout.item_vole, parent,false);
        return new Container(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_voles.Container holder, int position) {
        holder.nom_pilote.setText(""+voles.get(position).getPilote());
        holder.ID_vole.setText(""+voles.get(position).getID());
        holder.nom_avion.setText(""+voles.get(position).getAvion());
        holder.date_vole.setText(""+voles.get(position).getDate().toString());
    }

    @Override
    public int getItemCount() {
        return voles.size();
    }

    public class Container extends RecyclerView.ViewHolder implements View.OnClickListener  {
        TextView nom_pilote, nom_avion, date_vole, ID_vole;
        public Container(@NonNull View itemView) {
            super(itemView);
            this.nom_pilote = itemView.findViewById(R.id.case_vole_nom_pilote);
            this.nom_avion = itemView.findViewById(R.id.case_vole_nom_avion);
            this.date_vole = itemView.findViewById(R.id.case_vole_date);
            this.ID_vole = itemView.findViewById(R.id.case_vole_ID);

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
