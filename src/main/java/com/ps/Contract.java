package com.ps;

public abstract class Contract {
    private String date;
    private String customerName;
    private String email;
    private Vehicle vehicle;

    public Contract(String date, String customerName, String email, Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.email = email;
        this.vehicle = vehicle;
    }

    public Contract(){}

    abstract public void getTotalPrice();

    abstract public double getMonthlyPayment();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "date='" + date + '\'' +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", vehicleSold=" + vehicle +
                '}';
    }
}
