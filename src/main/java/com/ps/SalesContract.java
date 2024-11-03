package com.ps;

public class SalesContract extends Contract {

    private static final double tax = 0.05;
    private static final double recFee = 100;
    private double proFee;
    private boolean isFinanced;

    public SalesContract(String date,
                         String customerName,
                         String email,
                         Vehicle vehicle,
                         boolean isFinanced) {
        super(date, customerName, email, vehicle);
        //this.proFee = proFee;
        this.isFinanced = isFinanced;

        if(vehicle.getPrice() < 10000)
        {
            this.proFee = 295;
        }else{
            this.proFee = 495;
        }


    }

    public double getTax() {
        return tax;
    }


    public double getRecFee() {
        return recFee;
    }


    public double getProFee() {
        return proFee;
    }

    public void setProFee(double proFee) {
        this.proFee = proFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean isFinanced) {
        this.isFinanced = isFinanced;
    }

    @Override
    public void getTotalPrice() {
        double basePrice = getVehicle().getPrice();
        double taxRate = basePrice * tax;
        double totalPrice = basePrice + taxRate + recFee + proFee;
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) {
            return 0.0;
        }

        double price = getVehicle().getPrice();
        double interestRate;
        int termMonths;

        // Determine interest rate and term length
        if (price >= 10000) {
            interestRate = 0.0425; // 4.25%
            termMonths = 48;       // 48 months
        } else {
            interestRate = 0.0525; // 5.25%
            termMonths = 24;       // 24 months
        }


        double monthlyInterestRate = interestRate / 12;
        double monthlyPayment = price * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, termMonths)) /
                (Math.pow(1 + monthlyInterestRate, termMonths) - 1);

        return monthlyPayment;
    }


}

