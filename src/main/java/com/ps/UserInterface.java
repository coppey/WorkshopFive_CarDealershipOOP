package com.ps;
import java.util.*;

public class UserInterface
{
    //private static Dealership dealership
    private static Dealership dealership;

    public static Scanner commandScanner = new Scanner(System.in);
    public static Scanner inputScanner = new Scanner(System.in);

    public static void init(){
        //System.out.println("Init Method");
        dealership = DealershipFileManager.getDealership();
        //loading dealership and inventory from file
    }
    public static void display(){

        //loading Dealership
        init();
        DealershipFileManager.saveDealership(dealership);
        //System.out.println("Display Menu");
        loadMenu();
    }

    public static void loadMenu()
    {
        int command;

        //load menu
        do {
            System.out.println("Welcome to the Dealership");
            System.out.println("What do you want to do?\n" +
                    "1) Get Vehicles by price\n" +
                    "2) Get Vehicles by Make and Model\n" +
                    "3) Get Vehicles by Year\n" +
                    "4) Get Vehicles by Color\n" +
                    "5) Get Vehicles by Mileage\n" +
                    "6) Get Vehicles by Type\n" +
                    "7) View All Vehicles\n" +
                    "8) Add Vehicle\n" +
                    "9) Remove Vehicle\n" +
                    "0) Exit Dealership\n" +
                    "Command: ");
            command = commandScanner.nextInt();

            switch (command){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command");
            }

        }while(command != 0);
    }

    private static void displayVehicles(List<Vehicle>vehicles)
    {
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

    public static void processGetByPriceRequest(){
        System.out.println("Please Enter your Price Range\n" +
                "Enter minimum price: ");
        double minPrice = inputScanner.nextDouble();

        System.out.print("\nEnter maximum price: ");
        double maxPrice = inputScanner.nextDouble();

        List<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehiclesByPrice);
    }

    public static void processGetByMakeModelRequest(){
        System.out.println("Please Enter the Make and Model of your desired Vehicle\n" +
                "Enter Make of Vehicle: ");
        String make = inputScanner.nextLine();

        System.out.print("\nEnter the Model of Vehicle: ");
        String model = inputScanner.nextLine();

        List<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehiclesByMakeModel);
    }

    public static void processGetByYearRequest(){
        System.out.println("Please Enter your Desired Year of Production\n" +
                "Year: ");
        int year = inputScanner.nextInt();

        List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(year);
        displayVehicles(vehiclesByYear);
    }

    public static void processGetByColorRequest(){
        System.out.println("Please Enter the Color of your desired Vehicle\n" +
                "Color: ");
        String color = inputScanner.nextLine();

        List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);
        displayVehicles(vehiclesByColor);
    }

    public static void processGetByMileageRequest(){
        System.out.println("Please Enter how many Miles you want on your vehicle\n" +
                "Odometer Stats(In Miles): ");
        int odometer = inputScanner.nextInt();

        List<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(odometer);
        displayVehicles(vehiclesByMileage);
    }

    public static void processGetByVehicleTypeRequest(){
        System.out.println("Please Enter the Type of Vehicle you desire\n" +
                "Types include: SUV, Van, Truck, Sedan, Coupe, Sports Coupe, Unconventional\n" +
                "Desired Type: ");
        String type = inputScanner.nextLine();

        List<Vehicle> vehiclesByType = dealership.getVehiclesByType(type);
        displayVehicles(vehiclesByType);
    }

    public static void processGetAllVehiclesRequest(){

        //dealership.getAllVehicles();
        System.out.println("Displaying all vehicles");
        //System.out.println(dealership.getAllVehicles());

        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public static void processAddVehicleRequest(){
        System.out.print("Please Enter the Following information for the Vehicle you'd like to add\n" +
                "vin: ");
        int vin = inputScanner.nextInt();
        System.out.print("\nColor: ");
        String color = inputScanner.nextLine();
        System.out.print("\nYear: ");
        int year = inputScanner.nextInt();
        System.out.print("\nMake: ");
        String make = inputScanner.nextLine();
        System.out.print("\nModel: ");
        String model = inputScanner.nextLine();
        System.out.print("\nType: ");
        String type = inputScanner.nextLine();
        System.out.print("\nMileage: ");
        int odometer = inputScanner.nextInt();
        System.out.print("\nPrice: ");
        double price = inputScanner.nextDouble();

        Vehicle car = new Vehicle(vin, year, color, make, model, type, odometer, price);
        dealership.addVehicle(car);

        System.out.println("Vehicle Added to Dealership");
    }

    public static void processRemoveVehicleRequest(){
        System.out.println("Please enter the vin# of the Vehicle you'd like to remove\n" +
                "Vin#: ");
        int vin = inputScanner.nextInt();

        Vehicle vehicleToRemove = null;

        for(Vehicle vehicle : dealership.getAllVehicles()){
            if (vehicle.getVin() == vin){
                vehicleToRemove = vehicle;
                break;
            }
        }
    }
}