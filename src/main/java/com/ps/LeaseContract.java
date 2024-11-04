package com.ps;

public class LeaseContract extends Contract {

    private double endValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String email, Vehicle vehicle) {
        super(date, customerName, email, vehicle);
        this.endValue = vehicle.getPrice() * 0.5;
        this.leaseFee = vehicle.getPrice() * 0.07;
    }

    public double getEndValue() {
        return endValue;
    }

    public void setEndValue(double endValue) {
        this.endValue = endValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public void getTotalPrice() {
        double totalPrice = getVehicle().getPrice() - endValue + leaseFee;
        System.out.printf("Total Price for Lease: $%.2f%n", totalPrice);

    }

    @Override
    public double getMonthlyPayment() {
        double principal = getVehicle().getPrice() - endValue;
        double annualInterestRate = 0.04;
        int months = 36;
        double monthlyInterestRate = annualInterestRate / 12;

        // Formula for calculating monthly payment
        double monthlyPayment = (principal * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -months));

        return monthlyPayment;
    }


}
