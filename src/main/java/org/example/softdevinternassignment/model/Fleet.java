package org.example.softdevinternassignment.model;

import org.example.softdevinternassignment.model.vehicles.VehicleBase;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private final List<VehicleBase> vehicles;

    public Fleet(){
        vehicles= new ArrayList<VehicleBase>();
    }

    public void addVehicle(VehicleBase vehicle){
        vehicles.add(vehicle);
    }
    public List<VehicleBase> getVehicles() {
        return vehicles;
    }
}
