package com.example.c0775497_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DataDisplayActivity extends AppCompatActivity {

    private TextView txtSin,txtFullName,txtBirthDate,txtAge,txtGender;
    private TextView txtTaxFilingDate,txtGrossIncome,txtRrsp,lblRRSPCarryFwd;
    private TextView txtFederalTax,txtProvincialTax,txtEi,txtCpp,txtTaxableIncome,txtTaxPayed;

    double cpp = 0;
    double ei = 0;
    double rrsp = 0, rrspContribution = 0, rrspCarryFwd = 0;
    double taxableIncome, federalTax, provincialTax, totalTaxPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);

        txtSin = findViewById(R.id.txtSinNumber);
        txtFullName = findViewById(R.id.txtFullName);
        txtBirthDate = findViewById(R.id.txtBirthDate);
        txtAge = findViewById(R.id.txtAge);
        txtGender = findViewById(R.id.txtGender);
        txtTaxFilingDate = findViewById(R.id.txtTaxFillDate);
        txtGrossIncome = findViewById(R.id.txtGrossIncome);
        txtRrsp = findViewById(R.id.txtRrsp);
        lblRRSPCarryFwd = findViewById(R.id.txtCarry);
        txtFederalTax = findViewById(R.id.txtFederalTax);
        txtProvincialTax = findViewById(R.id.txtProvincialTax);
        txtEi = findViewById(R.id.txtEi);
        txtCpp = findViewById(R.id.txtCpp);
        txtTaxableIncome = findViewById(R.id.txtTotalTaxIncome);
        txtTaxPayed = findViewById(R.id.txtTaxPayed);
    }
}
