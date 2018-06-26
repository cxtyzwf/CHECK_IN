package com.example.weifeng.check_in.check;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by 维枫 on 2018/4/3.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private CheckActivity activity;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        activity = (CheckActivity) getActivity();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(getActivity(),this,year,month,day);
        return dialog;

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        activity.setText(i,i1,i2);
    }
}

