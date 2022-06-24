package main.java.com.vrs.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Branch {

    // private String id;
    private String city;
    private String name;

    private Map cost;

    private List Cars;

    public Branch(String name) {
        this.city = "Delhi";
        this.name = name;
        this.cost = new HashMap();
    }

    public void setCostByType(CarType carType,int cost) {
        this.cost.put(carType, cost);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map getCost() {
        return cost;
    }

    public void setCost(HashMap cost) {
        this.cost = cost;
    }

    public List getCars() {
        return Cars;
    }

    public void setCars(List cars) {
        Cars = cars;
    }
}
