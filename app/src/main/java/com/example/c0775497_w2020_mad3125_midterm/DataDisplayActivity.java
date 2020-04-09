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

        totalTaxPaid = calculateFederal+ calculateProvincial;
        txtTaxPayed.setText( String.format("%.2f",totalTaxPaid));
    }

    public double calculateFedralTax(){
        double temp = taxableIncome ;
        if(temp <= 12069.00){
            federalTax = 0;//0%
            temp = taxableIncome - 12069.00;
        }
        if(temp >= 12069.01){
            federalTax = (temp * 0.15);//15%
            temp = temp - 35561;
        }
        if(temp >= 47630.01){
            federalTax = (temp * 0.205); //20.50%
            temp = temp - 47628.99;
        }
        if(temp >= 95259.01){
            federalTax = (temp * 0.26); //26%
            temp = temp - 52407.99;
        }
        if (temp >= 147667.01){
            federalTax = (temp * 0.29);//29%
            temp = temp - 62703.99;
        }
        if(temp >= 210371.01){
            federalTax = (temp * 0.33);//33%
            //temp = temp - federalTax;
        }
        return federalTax;
    }

    public  double calculateProvincialTax(){
        double temp = taxableIncome ;

        if(temp <= 10582.00){
            provincialTax = 0;
            temp = taxableIncome - 10582.00;
        }
        if(temp >= 10582.01){
            provincialTax = (temp * 0.0505); //5.05%
            temp = temp - 33323.99;
        }
        if(temp >= 43906.01){
            provincialTax = (temp * 0.0915); //9.15%
            temp = temp - 43906.99;
        }
        if(temp >= 87813.01){
            provincialTax = (temp * 0.1116); //11.16%
            temp = temp - 62187.99;
        }
        if (temp >= 150000.01){
            provincialTax = (temp * 0.1216);//12.16%
            temp = temp - 69999.99;
        }
        if(temp >= 220000.01){
            provincialTax = (temp * 0.1316);//13.16%

        }
        return provincialTax;
    }
}
