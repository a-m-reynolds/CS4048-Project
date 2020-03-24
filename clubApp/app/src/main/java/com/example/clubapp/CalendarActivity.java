package com.example.clubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;

public class CalendarActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    //FirestoreRecyclerOptions<Equipment> model;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        showDatePicker();
    }

    private void showDatePicker() {
        DatePickerDialog datePicker = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePicker.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){

        String text= dayOfMonth + "/" + month +"/" + year;
        //int equipID  =
        //int userID =
        Map<String, Object> rent = new HashMap<>();
        rent.put("equipmentId", "2");
        rent.put("userId", "2");
        rent.put("Date", text);

        db.collection("rented").add(rent);
        Toast.makeText(CalendarActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}
