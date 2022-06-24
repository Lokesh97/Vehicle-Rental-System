package main.java.com.vrs;

import main.java.com.vrs.services.RentalServiceImpl;
import main.java.com.vrs.services.RentalServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RentalServices rentalService= new RentalServiceImpl();

        while(true) {
            System.out.println("1. addBranch");
            System.out.println("2. allocatePrice");
            System.out.println("3. addVehicle");
            System.out.println("4. bookVehicle");
            System.out.println("5. viewVehicleInventory");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Branch name:");
                    sc = new Scanner(System.in);
                    String name = sc.nextLine();
                    System.out.println(rentalService.addBranch(name));
                    break;
                case 2:
                    System.out.println("Branch name");
                    sc = new Scanner(System.in);
                    name = sc.nextLine();
                    System.out.println("VehicleType");
                    sc = new Scanner(System.in);
                    String type = sc.nextLine();
                    System.out.println("price");
                    sc = new Scanner(System.in);
                    int p = sc.nextInt();
                    System.out.println(rentalService.allocatePrice(name, type, p));
                    break;
                case 3:
                    System.out.println("Branch name");
                    sc = new Scanner(System.in);
                    name = sc.nextLine();
                    System.out.println("VehicleId");
                    sc = new Scanner(System.in);
                    String id = sc.nextLine();
                    System.out.println("type");
                    sc = new Scanner(System.in);
                    type = sc.nextLine();
                    System.out.println(rentalService.addVehicle(id, type, name));
                    break;
                case 4:
                    System.out.println("type");
                    sc = new Scanner(System.in);
                    type = sc.nextLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
                    Date start = null, end = null;
                    String date1, date2;
                    sc = new Scanner(System.in);
                    date1 = sc.next();
                    date2 = sc.next();
                    try {
                        //Parsing the String
                        start = sdf.parse(date1);
                        end = sdf.parse(date2);
                        System.out.println(rentalService.bookVehicle(type, start, end));
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    sdf = new SimpleDateFormat("dd-mm-yyyy");
                    sc = new Scanner(System.in);
                    date1 = sc.next();
                    date2 = sc.next();
                    try {
                        //Parsing the String
                        start = sdf.parse(date1);
                        end = sdf.parse(date2);
                        System.out.println(rentalService.viewVehicleInventory(start, end));
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
            }
        }

    }
}
