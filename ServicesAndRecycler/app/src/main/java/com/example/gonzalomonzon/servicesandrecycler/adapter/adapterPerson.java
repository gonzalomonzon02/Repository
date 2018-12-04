package com.example.gonzalomonzon.servicesandrecycler.adapter;


import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gonzalomonzon.servicesandrecycler.Model.Person;
import com.example.gonzalomonzon.servicesandrecycler.R;
import com.example.gonzalomonzon.servicesandrecycler.ui.dialogs.DialogItems;

import java.util.ArrayList;

public class adapterPerson extends RecyclerView.Adapter<adapterPerson.MyViewHolder> {

    public ArrayList<Person> list;

    public adapterPerson(ArrayList<Person> listPer) {
        list = listPer;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_person, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        final String name, lastName, id;
        int age;
        name = list.get(i).getName();
        lastName = list.get(i).getLastName();
        id = list.get(i).getId();
        age = list.get(i).getAge();

        myViewHolder.id.setText(id);
        myViewHolder.lastName.setText(lastName);
        myViewHolder.age.setText(String.valueOf(age));
        myViewHolder.name.setText(name);

        myViewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///DIALOG
                Context context = myViewHolder.age.getContext();

                AlertDialog dialog = new AlertDialog.Builder(context)
                        .setMessage("Hola")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // FIRE ZE MISSILES!
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        })
                        .create();

                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView lastName;
        TextView id;
        EditText age;
        View layout;

        public MyViewHolder(View view) {
            //aca es donde se instancia cada control que se va a repetir
            super(view);
            name = view.findViewById(R.id.name);
            lastName = view.findViewById(R.id.last_name);
            id = view.findViewById(R.id.id);
            age = view.findViewById(R.id.age);
            layout=view.findViewById(R.id.rectangle);
        }

    }
}


