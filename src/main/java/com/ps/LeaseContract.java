package com.ps;

public class LeaseContract extends Contract {

    private double endValue;
    private double lesFee;

    public LeaseContract(String date, String customerName, String email, Vehicle vehicle, double lesFee, double endValue) {
        super(date, customerName, email, vehicle);
        this.lesFee = lesFee;
        this.endValue = endValue;
    }

    public double getEndValue() {
        return endValue;
    }

    public void setEndValue(double endValue) {
        this.endValue = endValue;
    }

    public double getLesFee() {
        return lesFee;
    }

    public void setLesFee(double lesFee) {
        this.lesFee = lesFee;
    }

    @Override
    public void getTotalPrice() {

    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
