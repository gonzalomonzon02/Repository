package com.example.gonzalomonzon.servicesandrecycler.ui.adapters;


import android.content.Context;
import android.content.DialogInterface;
import android.databinding.adapters.ActionMenuViewBindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.gonzalomonzon.servicesandrecycler.Model.Person;
import com.example.gonzalomonzon.servicesandrecycler.R;
import com.example.gonzalomonzon.servicesandrecycler.databinding.ItemPersonBinding;
import com.example.gonzalomonzon.servicesandrecycler.databinding.ItemPersonBindingImpl;
import com.example.gonzalomonzon.servicesandrecycler.utils.GlideApp;

import java.util.ArrayList;
import java.util.Timer;
import java.util.logging.Handler;

public class adapterPerson extends RecyclerView.Adapter<adapterPerson.MyViewHolder> {

    public ArrayList<Person> list;

    public adapterPerson(Context context, ArrayList<Person> listPer) {
        this.context = context;
        list = listPer;
    }

    private Context context;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemPersonBinding asd = ItemPersonBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new MyViewHolder(asd);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        final String url, name, lastName, id;
        int age;
        name = list.get(i).getName();
        lastName = list.get(i).getLastName();
        id = list.get(i).getId();
        age = list.get(i).getAge();

        url = list.get(i).getUrl();

        myViewHolder.id.setText(id);
        myViewHolder.lastName.setText(lastName);
        myViewHolder.age.setText(String.valueOf(age));
        myViewHolder.name.setText(name);

        //library drawable image
        //Glide.with(context).load(url).into(myViewHolder.imageView);
        /*Glide.with(context).load(url).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                myViewHolder.progressBar.setVisibility(View.GONE);

                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                myViewHolder.progressBar.setVisibility(View.GONE);
                return false;
            }

        }).into(myViewHolder.imageView);*/

        GlideApp.with(context).load(url).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                myViewHolder.progressBar.setVisibility(View.GONE);

                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                myViewHolder.progressBar.setVisibility(View.GONE);
                return false;
            }

        }).error(R.drawable.image_not_found).into(myViewHolder.imageView);

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
        ImageView imageView;
        TextView name;
        TextView lastName;
        TextView id;
        EditText age;
        ProgressBar progressBar;
        View layout;

        ItemPersonBinding binding;

        public MyViewHolder(ItemPersonBinding binding) {
            //aca es donde se instancia cada control que se va a repetir
            super(binding.getRoot());
            this.binding = binding;

            progressBar=binding.progresImage;
            imageView=binding.imageView;
            name=binding.name;
            lastName=binding.lastName;
            id=binding.id;
            age=binding.age;
            layout=binding.rectangle;

        }

    }

}


