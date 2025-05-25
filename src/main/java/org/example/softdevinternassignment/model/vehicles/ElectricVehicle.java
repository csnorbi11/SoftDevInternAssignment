package org.example.softdevinternassignment.model.vehicles;

public class ElectricVehicle extends VehicleBase {
    public ElectricVehicle(int capacity, int range) {
        super(capacity, range);
    }

    @Override
    public int getRemainingFuel(int distance) {
        return range-distance;
    }

    @Override
    public int getRefuelCost(int distance) {
        return getRemainingFuel(distance);
    }
}
