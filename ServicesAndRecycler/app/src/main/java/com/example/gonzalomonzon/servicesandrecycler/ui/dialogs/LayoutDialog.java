package com.example.gonzalomonzon.servicesandrecycler.ui.dialogs;

import android.app.Dialog;
import android.content.Context;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.gonzalomonzon.servicesandrecycler.R;

import java.text.SimpleDateFormat;

public class LayoutDialog {

    public LayoutDialog(Context context) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        // dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.green(123123)));
        dialog.setContentView(R.layout.layout_dialog);
        final CalendarView calendarView=dialog.findViewById(R.id.calendar);
        dialog.show();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Toast.makeText(dialog.getContext(),String.valueOf(sdf.format(calendarView.getDate())),Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }
}
