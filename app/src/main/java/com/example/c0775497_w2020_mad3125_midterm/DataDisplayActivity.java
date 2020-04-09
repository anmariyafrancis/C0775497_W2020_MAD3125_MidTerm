package com.example.c0775497_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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

        Intent mIntent = getIntent();
        CRACustomer customer = mIntent.getParcelableExtra("CRACustomer");

        txtSin.setText( customer.getSinNumber());
        txtFullName.setText( customer.getFull_name());
        txtGender.setText(getIntent().getStringExtra("gender"));
        txtGrossIncome.setText(String.valueOf(customer.getGrossIncome()));
        txtRrsp.setText(String.valueOf(customer.getRrspContribution()));

        double grossIncome = customer.getGrossIncome();
        if(grossIncome > 57400.00){
            cpp = (57400.00 * 0.051); //5.10%
        } else {
            cpp = (grossIncome * 0.051);
        }
        txtCpp.setText(String.format("%.2f", cpp));

        if(grossIncome > 53100){
            ei = (53100 * 0.0162); //1.62%
        }else{
            ei = (grossIncome * (1.62/100));
        }
        txtEi.setText(String.format("%.2f", ei));

        rrsp = customer.getRrspContribution();
        double maxRRSP = (grossIncome * 0.18); //18%

        rrspCarryFwd = maxRRSP - rrsp ;

        if(rrspCarryFwd < 0)
        {
            lblRRSPCarryFwd.setTextColor(Color.RED);
            lblRRSPCarryFwd.setText(String.format("%.2f",rrspCarryFwd));
        }
        else
        {
            lblRRSPCarryFwd.setText(String.format("%.2f",rrspCarryFwd));
        }

        taxableIncome = grossIncome - (cpp + ei + rrsp);
        txtTaxableIncome.setText(String.format("%.2f",taxableIncome));

        double calculateFederal = calculateFedralTax();
        txtFederalTax.setText( String.format("%.2f",calculateFederal));

        double calculateProvincial = calculateProvincialTax();
        txtProvincialTax.setText(String.format("%.2f",calculateProvincial));

        //Total
        totalTaxPaid = calculateFederal+ calculateProvincial;

        lblTaxPayed.setText( String.format("%.2f",totalTaxPaid));
    }
}
