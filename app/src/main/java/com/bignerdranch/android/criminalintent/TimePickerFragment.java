package com.bignerdranch.android.criminalintent;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by bubujay on 10/21/15.
 */
public class TimePickerFragment extends DialogFragment {
    public static final String EXTRA_TIME =
            "com.bignerdranch.android.criminalintent.time";
    private static final String ARG_TIME =
            "time";

    private TimePicker mTimePicker;

    public static TimePickerFragment newInstance(Time time){
        Bundle args = new Bundle();
        args.putSerializable(ARG_TIME, time);

        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Time time = (Time) getArguments().getSerializable(ARG_TIME);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        //int second = calendar.get(Calendar.SECOND);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_time, null);

        mTimePicker = (TimePicker) v.findViewById(R.id.dialog_time_time_picker);
        mTimePicker.setMinute(minute);
        mTimePicker.setHour(hour);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Date of crime")
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int hour = mTimePicker.getHour();
                                int minute = mTimePicker.getMinute();
                                long milliTime = hour * 60 + minute;
                                Time time = new Time(milliTime);
                                sendResult(Activity.RESULT_OK, time);
                            }
                        })
                .create();
    }
    private void sendResult(int resultCode, Time time) {
        if(getTargetFragment() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME, time);

        getTargetFragment()
                .onActivityResult(getTargetRequestCode(), resultCode, intent);
    }


}
