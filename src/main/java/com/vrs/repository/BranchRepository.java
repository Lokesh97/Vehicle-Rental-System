package main.java.com.vrs.repository;

import main.java.com.vrs.entity.Branch;
import main.java.com.vrs.entity.CarType;

import java.util.HashMap;
import java.util.Map;

public class BranchRepository {

    Map branchMapByName;

    public BranchRepository() {
        this.branchMapByName = new HashMap<String, Branch>();
    }

    public void addBranch(Branch branch){
        branchMapByName.put(branch.getName(), branch);
    }

    public void modifyBranchCost(String name, CarType carType, int cost){
        Branch branch = (Branch) branchMapByName.get(name);
        branch.setCostByType(carType, cost);
    }

    public Branch getBranchByName(String name){
        if(branchMapByName.containsKey(name)){
            return (Branch) branchMapByName.get(name);
        }

        return null;
    }
}
