package main.java.com.vrs.repository;

import main.java.com.vrs.entity.Car;
import main.java.com.vrs.entity.CarType;

import java.util.*;

public class CarRepository {

    private Map carsByType;
    private Map carsById;

    public CarRepository() {
        this.carsByType = new HashMap<CarType, List>();
        this.carsById = new HashMap<String, Car>();
    }

    public List getCarsByType(CarType carType){
        return (List) carsByType.get(carType);
    }

    public Car getCarById(String id){
        return (Car) carsById.get(id);
    }

    public void addCarsByType(Car car){
        CarType carType = car.getCarType();
        if(!carsByType.containsKey(carType)){
            carsByType.put(carType, new ArrayList<>());
        }
        List carsList = (List) carsByType.get(carType);
        carsList.add(car);
        carsById.put(car.getId(), car);
    }

    public Map getInventory(Date start, Date end){
        Map cars = new HashMap<String, List>();

        this.carsById.forEach((key, value) -> {
            Car car = (Car) value;
            if(car.isAvailable(start, end)){
                if(!cars.containsKey(car.getBranch().getName())){
                    cars.put(car.getBranch().getName(), new ArrayList<>());
                }
                List carsList = (List) cars.get(car.getBranch().getName());
                carsList.add(car);
            }
        });

        return cars;
    }
}
