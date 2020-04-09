package com.example.c0775497_w2020_mad3125_midterm;

import java.util.Date;

public class CRACustomer {
    private String sinNumber;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String age;
    private Date taxFilingDate;
    private Double grossIncome;
    private Double federalTax;
    private Double provincialTax;
    private Double cpp;
    private Double ei;
    private Double rrspContribution;
    private Double totalTaxableIncome;
    private Double totalTaxPayed;

    public CRACustomer(String sinNumber,String firstName,String lastName,String gender,Double grossIncome,Double rrspContribution){
        this.sinNumber=sinNumber;
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.grossIncome=grossIncome;
        this.rrspContribution=rrspContribution;
    }
}

