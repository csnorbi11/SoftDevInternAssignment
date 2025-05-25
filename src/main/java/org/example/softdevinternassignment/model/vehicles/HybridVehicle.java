package org.example.softdevinternassignment.model.vehicles;

public class HybridVehicle extends VehicleBase {
    public HybridVehicle(int capacity, int range) {
        super(capacity, range, 3,0.5f);

    }

    @Override
    public String toString() {
        return "HybridVehicle" + super.toString();
    }
}
