package com.example.gonzalomonzon.peoplecollections;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class FragmentOne extends Fragment {
    View view;

    public FragmentOne() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.one_fragment, container, false);
        printSpinner(view);

        /*Spinner spinner=view.findViewById(R.id.planets_spinner);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        Toast.makeText(view.getContext(),"Presiono items 1",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(view.getContext(),"Presiono items 2",Toast.LENGTH_SHORT).show();
                        break;
                }
            }});*/
        addListenerOnSpinnerItemSelection();

        return view;
    }

    public void printSpinner(View view) {
        Spinner spinner;
        spinner = view.findViewById(R.id.planets_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.aray_string_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public void addListenerOnSpinnerItemSelection() {
        Spinner spinner;
        spinner = view.findViewById(R.id.planets_spinner);
        spinner.setOnItemSelectedListener(new SpinnerControl());
    }


}
