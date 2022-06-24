package main.java.com.vrs.vehicleSelectionStrategy;

import main.java.com.vrs.entity.Car;
import main.java.com.vrs.entity.CarType;

import java.util.Date;
import java.util.List;

public class MinCostCarSelectionStrategy implements CarSelectionStrategy {
    @Override
    public Car selectCar(List Cars, CarType carType, Date startTime, Date endTime) {
        Car selectedCar = null;

        for(Object o: Cars){
            Car car = (Car) o;

            if(car.isAvailable(startTime,endTime)){
                if(selectedCar==null){
                    selectedCar = car;
                } else {
                    if(car.getBranch().getCostByType(carType) < selectedCar.getBranch().getCostByType(carType)){
                        selectedCar = car;
                    }
                }
            }
        }

        return selectedCar;
    }
}
