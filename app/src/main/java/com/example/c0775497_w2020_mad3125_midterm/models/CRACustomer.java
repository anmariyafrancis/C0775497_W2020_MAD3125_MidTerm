package com.example.c0775497_w2020_mad3125_midterm.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class CRACustomer implements Parcelable{
    private String sinNumber;
    private String firstName;
    private String lastName;
    private String fullName;
    private Date birthDate;
    private String gender;
    private String age;
    private Date taxFilingDate;
    private Double grossIncome;
    private Double federalTax;
    private Double provincialTax;
    private Double cpp;
    private Double ei;
    private Double rrspCarryForward;
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

    public String getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(String sinNumber) {
        this.sinNumber = sinNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return getFirstName()+getLastName();
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getTaxFilingDate() {
        return taxFilingDate;
    }

    public void setTaxFilingDate(Date taxFilingDate) {
        this.taxFilingDate = taxFilingDate;
    }

    public Double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public Double getFederalTax() {
        return federalTax;
    }

    public void setFederalTax(Double federalTax) {
        this.federalTax = federalTax;
    }

    public Double getProvincialTax() {
        return provincialTax;
    }

    public void setProvincialTax(Double provincialTax) {
        this.provincialTax = provincialTax;
    }

    public Double getCpp() {
        return cpp;
    }

    public void setCpp(Double cpp) {
        this.cpp = cpp;
    }

    public Double getEi() {
        return ei;
    }

    public void setEi(Double ei) {
        this.ei = ei;
    }

    public Double getRrspContribution() {
        return rrspContribution;
    }

    public void setRrspContribution(Double rrspContribution) {
        this.rrspContribution = rrspContribution;
    }

    public Double getTotalTaxableIncome() {
        return totalTaxableIncome;
    }

    public void setTotalTaxableIncome(Double totalTaxableIncome) {
        this.totalTaxableIncome = totalTaxableIncome;
    }

    public Double getTotalTaxPayed() {
        return totalTaxPayed;
    }

    public void setTotalTaxPayed(Double totalTaxPayed) {
        this.totalTaxPayed = totalTaxPayed;
    }

    protected CRACustomer(Parcel parcel) {
        sinNumber = parcel.readString();
        firstName = parcel.readString();
        lastName = parcel.readString();
        gender = parcel.readString();
        provincialTax = parcel.readDouble();
        federalTax = parcel.readDouble();
        rrspContribution = parcel.readDouble();
        grossIncome = parcel.readDouble();
        rrspContribution = parcel.readDouble();
        ei = parcel.readDouble();
        totalTaxableIncome = parcel.readDouble();
        totalTaxPayed = parcel.readDouble();
    }

    public String amountFormatter() {
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String val = nf.format("$" + this);
        return val;
    }

    public static final Parcelable.Creator<CRACustomer> CREATOR = new Parcelable.Creator<CRACustomer>() {
        @Override
        public CRACustomer createFromParcel(Parcel parcel) {
            return new CRACustomer(parcel);
        }

        @Override
        public CRACustomer[] newArray(int size) {
            return new CRACustomer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sinNumber);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(gender);
        dest.writeDouble(provincialTax);
        dest.writeDouble(federalTax);
        dest.writeDouble(rrspCarryForward);
        dest.writeDouble(grossIncome);
        dest.writeDouble(rrspContribution);
        dest.writeDouble(ei);
        dest.writeDouble(totalTaxableIncome);
        dest.writeDouble(totalTaxPayed);
    }
}

