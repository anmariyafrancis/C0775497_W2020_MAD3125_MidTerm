package com.example.c0775497_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

public class PersonInfoEntryActivity extends AppCompatActivity {

    private Button btnCalculate;
    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtSinNumber;
    private EditText edtDOB;
    private TextView edtTaxFiledDate;
    private EditText edtGrossIncome;
    private EditText edtRRSP;
    private RadioButton rbtnMale;
    private RadioButton rbtnFemale;
    private RadioButton rbtnOther;
    private RadioGroup rdGender;
    private DatePickerDialog picker;

    final Calendar calendar = Calendar.getInstance();
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final   int month = calendar.get(Calendar.MONTH);
    final int year = calendar.get(Calendar.YEAR);
    String gender=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
