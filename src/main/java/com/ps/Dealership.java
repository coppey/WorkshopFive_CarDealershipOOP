package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    ArrayList<Vehicle> inventory;

    public Dealership(String address,
                      String name,
                      String phone)
    {
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> pricedVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max)
            {
                pricedVehicles.add(vehicle);
            }
        return pricedVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> makeModelVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model))
            {
                makeModelVehicles.add(vehicle);
            }
        return makeModelVehicles;
    }

    public List<Vehicle> getVehiclesByYear(int year) {
        List<Vehicle> yearVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if(vehicle.getYear() == year)
            {
                yearVehicles.add(vehicle);
            }
        return yearVehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> coloredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if(vehicle.getMake().equalsIgnoreCase(color))
            {
                coloredVehicles.add(vehicle);
            }
        return coloredVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int odometer) {
        List<Vehicle> mileVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if(vehicle.getYear() == odometer)
            {
                mileVehicles.add(vehicle);
            }
        return mileVehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> typeVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if(vehicle.getMake().equalsIgnoreCase(vehicleType))
            {
                typeVehicles.add(vehicle);
            }
        return typeVehicles;
    }

    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
        DealershipFileManager.saveDealership(this);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
        DealershipFileManager.saveDealership(this);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}