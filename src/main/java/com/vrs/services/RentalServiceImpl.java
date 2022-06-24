package main.java.com.vrs.services;

import main.java.com.vrs.entity.Branch;
import main.java.com.vrs.entity.Car;
import main.java.com.vrs.entity.CarType;
import main.java.com.vrs.repository.BranchRepository;
import main.java.com.vrs.repository.CarRepository;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RentalServiceImpl implements RentalServices{

    private BranchRepository branchRepository;

    private CarRepository carRepository;

    public RentalServiceImpl() {
        this.branchRepository = new BranchRepository();
        this.carRepository = new CarRepository();
    }

    @Override
    public String addBranch(String branchName) {
        if(branchRepository.getBranchByName(branchName) != null){
            return "Branch Already Present";
        }
        this.branchRepository.addBranch(new Branch(branchName));
        return "Success";
    }

    @Override
    public String allocatePrice(String branchName, String vehicleType, int price) {
        Branch branch = branchRepository.getBranchByName(branchName);
        if(branch == null){
            return "Branch Not Present";
        }

        branchRepository.modifyBranchCost(branchName, CarType.valueOf(vehicleType.toUpperCase()), price);
        return "Success";
    }

    @Override
    public String addVehicle(String vehicleId, String vehicleType, String branchName) {
        Branch branch = branchRepository.getBranchByName(branchName);
        if(branch == null){
            return "Branch Not Present";
        }

        Car car = new Car(vehicleId, CarType.valueOf(vehicleType.toUpperCase()), branch);
        carRepository.addCarsByType(car);
        return "Success";
    }

    @Override
    public String bookVehicle(String vehicleType, Date startTime, Date endTime) {
        return null;
    }

    @Override
    public String viewVehicleInventory(Date startTime, Date endTime) {
        Map cars = carRepository.getInventory(startTime, endTime);

        cars.forEach((key,value) -> {
            System.out.println(key);

            List carsList = (List) value;
            for(Object o: carsList){
                Car car = (Car) o;
                System.out.println(car.getCarType() + " " + car.getId() + " Available");
            }
        });

        return "SUCCESS";
    }
}
