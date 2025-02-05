package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Component
public class Runner implements CommandLineRunner {
    private DriverService driverS;
    private CarService carS;
    private Init init;

    @Autowired
    public Runner(DriverService driverS, CarService carS, Init data_initilize) {
    this.driverS = driverS;
    this.carS = carS;
    this.init = data_initilize;
    }


    String show_menu = "Type anything for list of commands\n" + "Type 'quit' for closing app" ;
    String menu = "Type 1 -------- for showing all drivers\n" +
        "Type 2 -------- for showing all cars\n" +
        "Type 3 -------- for adding new element\n" +
        "Type 4 -------- delete element\n" +
        "Type 5 -------- quit\n";
    @Override
    public void run(String... args) throws Exception {
        init.init(); //data initialization
        System.out.println(show_menu);


        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("quit")){
            quit = true;
        }


        while (!quit) {
            System.out.println(menu);
            String command = scanner.next();
            switch (command) {
                case "1":
                    driverS.getDrivers().forEach(System.out::println);
                    break;
                case "2":
                    carS.getCars().forEach(System.out::println);
                    break;
                case "3":
                    add_car();
                    break;
                case "4":
                    carS.getCars().forEach(System.out::println);
                    System.out.println("Choose ID of the car you want to delete");
                    Scanner scan  = new Scanner(System.in);
                    String id = scan.nextLine();
                    Optional<Car> c = carS.getCarById(UUID.fromString(id));
                    if(c.isPresent()){
                        carS.delete(UUID.fromString(id));}
                    else{
                        System.out.println("Car not found");
                    }



                    break;
                case "5":
                    quit = true;
                }
        }
    }

    void add_car(){
        Car new_car = new Car();
        Scanner scanner = new Scanner(System.in);
        new_car.setId(UUID.randomUUID());
        System.out.println("Input brand of car\n");
        String brand = scanner.nextLine();
        new_car.setBrand(brand);
        System.out.println("Input model of car\n");
        String model = scanner.nextLine();
        new_car.setModel(model);
        System.out.println("Input VIN\n");
        String VIN = scanner.nextLine();
        new_car.setVIN(VIN);
        System.out.println("List of drivers and enter pesel of driver which will be assigned to car\n"+ driverS.getDrivers());
        String pesel = scanner.nextLine();
        Optional<Driver> driver = driverS.getDriverByPesel(pesel);
        if(driver.isPresent()){
            new_car.setDriver(driver.get());
        }
        carS.save(new_car);
    }
 }
