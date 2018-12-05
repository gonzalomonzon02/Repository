package com.example.gonzalomonzon.myapplication.a.ui.adapters;

import android.databinding.adapters.AbsListViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gonzalomonzon.myapplication.R;

import com.example.gonzalomonzon.myapplication.a.Model.Persona;

import java.util.ArrayList;

public class AdapterPersonas extends RecyclerView.Adapter<AdapterPersonas.MyViewHolder> {

    public ArrayList<Persona>list;

    public AdapterPersonas(ArrayList<Persona> listPer) {
        list=listPer;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_people, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        final String nombre,dni;
        nombre=list.get(i).getNombre();
        dni=list.get(i).getDni();
        myViewHolder.tvNombre.setText(nombre);
        myViewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),dni, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNombre;
        public Button btn;

        public MyViewHolder(View view) {
            //aca es donde se instancia cada control que se va a repetir
            super(view);
            this.tvNombre=view.findViewById(R.id.tv_nombre);
            btn=view.findViewById(R.id.btnDni);
        }
    }
}


