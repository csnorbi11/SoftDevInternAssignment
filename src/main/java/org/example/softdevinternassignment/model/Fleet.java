package org.example.softdevinternassignment.model;

import jakarta.annotation.PostConstruct;
import org.example.softdevinternassignment.model.vehicles.ElectricVehicle;
import org.example.softdevinternassignment.model.vehicles.GasolineVehicle;
import org.example.softdevinternassignment.model.vehicles.HybridVehicle;
import org.example.softdevinternassignment.model.vehicles.VehicleBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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

    /**
     * példa járművek teszteléshez
     */
    @PostConstruct
    public void init() {
        addVehicle(new GasolineVehicle( 5, 500));
        addVehicle(new HybridVehicle(3, 400));
        addVehicle(new ElectricVehicle(1,250));
    }
}
