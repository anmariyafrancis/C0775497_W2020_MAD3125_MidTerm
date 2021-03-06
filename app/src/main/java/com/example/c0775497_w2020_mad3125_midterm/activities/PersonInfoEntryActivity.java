package com.example.c0775497_w2020_mad3125_midterm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0775497_w2020_mad3125_midterm.R;

import java.util.Calendar;
import java.util.Date;

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

        edtFirstName = findViewById(R.id.txtFirstName);
        edtLastName = findViewById(R.id.txtLastName);
        edtSinNumber = findViewById(R.id.txtSinNumber);
        rdGender = findViewById(R.id.rdGrpGender);
        rbtnMale = findViewById(R.id.rdMale);
        rbtnFemale = findViewById(R.id.rdFeMale);
        rbtnOther = findViewById(R.id.rdOther);
        edtGrossIncome = findViewById(R.id.txtGrossIncome);
        edtRRSP =findViewById(R.id.txtRrsp);
        edtDOB = findViewById(R.id.txtBirthDate);
        edtTaxFiledDate = findViewById(R.id.txtTaxFillDate);
        btnCalculate = findViewById(R.id.btnCalculate);

        edtTaxFiledDate.setText(new StringBuilder()
                .append(day).append(" ").append("-").append(month + 1).append("-")
                .append(year));

        edtDOB.setInputType(InputType.TYPE_NULL);
        edtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker = new DatePickerDialog(PersonInfoEntryActivity.this,
                        new DatePickerDialog.OnDateSetListener() {


                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                edtDOB.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, year, month, day);
                picker.show();
            }
        });
        rdGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == R.id.rdMale){
                    gender = rbtnMale.getText().toString();
                }else if(i == R.id.rdFeMale){
                    gender = rbtnFemale.getText().toString();
                }else {
                    gender = rbtnOther.getText().toString();
                }
            }

        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldIsEmpty();
            }
        });
    }

    private void fieldIsEmpty() {
        boolean Flag = false;
        if(edtSinNumber.getText().toString().isEmpty())
        {
            edtSinNumber.setError("Please enter valid SIN");
            Flag = true;
            return;
        }
        if(edtFirstName.getText().toString().isEmpty()){
            edtFirstName.setError("Please enter your first name");
            Flag = true;
            return;
        }
        if(edtLastName.getText().toString().isEmpty())
        {
            edtLastName.setError("Please enter your last name");
            Flag = true;
            return;
        }
        if(edtDOB.getText().toString().isEmpty())
        {
            edtDOB.setError("Please enter correct date of birth");
            Flag = true;
            return;
        }
        if(edtGrossIncome.getText().toString().isEmpty())
        {
            edtGrossIncome.setError("Please enter your Gross Income");
            Flag = true;
            return;
        }
        if(edtRRSP.getText().toString().isEmpty())
        {
            edtRRSP.setError("Please enter your RRSP");
            Flag = true;
            return;
        }
    }
    int calculateAge(String date){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        String agee= String.valueOf(age);
        Toast.makeText(PersonInfoEntryActivity.this, agee, Toast.LENGTH_SHORT).show();
        if(today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)){
            age--;
        }
        return age;
    }

    public String getCurrentDate() {

        StringBuilder todaydate=new StringBuilder();
        Calendar today=Calendar.getInstance();
        int age=today.get(Calendar.YEAR)-picker.getDatePicker().getYear();
        if (today.get(Calendar.MONTH) < picker.getDatePicker().getYear()) {
            age--;
        } else if (today.get(Calendar.MONTH) == picker.getDatePicker().getYear()
                && today.get(Calendar.DAY_OF_MONTH) < picker.getDatePicker().getYear()) {
            age--;
        }
        todaydate.append(String.valueOf(age));
        return todaydate.toString();
    }
    Date date=java.util.Calendar.getInstance().getTime();
    String taxFiledDate = date.toString();
}
