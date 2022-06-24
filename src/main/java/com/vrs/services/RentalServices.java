package main.java.com.vrs.services;

import java.util.Date;

public interface RentalServices {

    public String addBranch(String branchName);
    public String allocatePrice(String branchName, String vehicleType, int price);
    public String addVehicle(String vehicleId,String vehicleType, String branchName);
    public String bookVehicle(String vehicleType, Date startTime, Date endTime);
    public String viewVehicleInventory(Date startTime,Date endTime);
}
