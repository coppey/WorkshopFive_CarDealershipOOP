package com.ps;

public class SalesContract extends Contract {

    private double tax;
    private double recFee;
    private double proFee;
    private boolean finace;

    public SalesContract(String date, String customerName, String email, Vehicle vehicleSold, double tax, double recFee, double proFee, boolean finace) {
        super(date, customerName, email, vehicleSold);
        this.tax = tax;
        this.recFee = recFee;
        this.proFee = proFee;
        this.finace = finace;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getRecFee() {
        return recFee;
    }

    public void setRecFee(double recFee) {
        this.recFee = recFee;
    }

    public double getProFee() {
        return proFee;
    }

    public void setProFee(double proFee) {
        this.proFee = proFee;
    }

    public boolean isFinace() {
        return finace;
    }

    public void setFinace(boolean finace) {
        this.finace = finace;
    }

    @Override
    public void getTotalPrice() {

    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
