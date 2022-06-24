package main.java.com.vrs.vehicleSelectionStrategy;

import main.java.com.vrs.entity.Car;
import main.java.com.vrs.entity.CarType;

import java.util.Date;
import java.util.List;

public interface CarSelectionStrategy {

    public Car selectCar(List Cars, CarType carType, Date startTime, Date endTime);
}
