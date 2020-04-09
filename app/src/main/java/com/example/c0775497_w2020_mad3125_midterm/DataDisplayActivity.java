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
    }
}
