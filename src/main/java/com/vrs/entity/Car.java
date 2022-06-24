package main.java.com.vrs.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Car {

    private String id;

    private CarType carType;

    private Branch branch;

    private List bookings;

    public Car(String id, CarType carType, Branch branch) {
        this.id = id;
        this.carType = carType;
        this.branch = branch;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public boolean isAvailable(Date start,Date end){
        for(Object o: bookings){
            Booking booking = (Booking) o;
            if((start.after(booking.getStart()) && start.before(booking.getEnd())) ||
                    (end.after(booking.getStart()) && end.before(booking.getEnd()))){
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
