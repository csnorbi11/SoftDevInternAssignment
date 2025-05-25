package org.example.softdevinternassignment.model;

public class GasolineVehicle extends VehicleBase {
    public GasolineVehicle(int capacity, int range) {
        super(capacity, range);
    }

    @Override
    public int getRemainingFuel(int distance) {
        return range-distance;
    }
}
