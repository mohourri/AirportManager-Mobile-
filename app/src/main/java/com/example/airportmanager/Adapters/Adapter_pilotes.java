package com.example.airportmanager.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airportmanager.R;
import com.example.airportmanager.classes.Pilote;
import com.example.airportmanager.interfaces.RecyclerViewInterface;

import java.util.ArrayList;

public class Adapter_pilotes extends RecyclerView.Adapter<Adapter_pilotes.Container> {
    private static RecyclerViewInterface recyclerViewInterface;
    Context c;
    ArrayList<Pilote> pilotes;

    public Adapter_pilotes(Context c, ArrayList<Pilote> pilotes, RecyclerViewInterface recyclerViewInterface) {
        this.c = c;
        this.pilotes = pilotes;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public Adapter_pilotes.Container onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(c);
        View v = inflater.inflate(R.layout.item_pilote, parent,false);
        return new Container(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_pilotes.Container holder, int position) {
        holder.nom_pilote.setText(pilotes.get(position).getNom()+" "+pilotes.get(position).getPrenom());
        holder.age_pilote.setText("age: "+pilotes.get(position).getAge()+" ans");
        holder.experience_pilote.setText("\t experience: "+pilotes.get(position).getExperience()+" ans");
    }

    @Override
    public int getItemCount() {
        return pilotes.size();
    }

    public static class Container extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nom_pilote, age_pilote, experience_pilote;
        public Container(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            this.nom_pilote = itemView.findViewById(R.id.case_nom_pilote);
            this.age_pilote = itemView.findViewById(R.id.case_age_pilote);
            this.experience_pilote = itemView.findViewById(R.id.case_experience_pilote);

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
