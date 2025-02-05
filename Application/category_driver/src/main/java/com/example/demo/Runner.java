package com.example.demo;


import com.example.demo.Driver.Driver;
import com.example.demo.Driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Component
public class Runner implements CommandLineRunner {
    private DriverService driverS;
    private Init init;

    @Autowired
    public Runner(DriverService driverS, Init data_initilize) {
    this.driverS = driverS;
    this.init = data_initilize;
    }


    String show_menu = "Type anything for list of commands\n" + "Type 'quit' for closing app" ;
    String menu = "Type 1 -------- for showing all drivers\n" +
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
                case "5":
                    quit = true;
                }
        }
    }


 }
