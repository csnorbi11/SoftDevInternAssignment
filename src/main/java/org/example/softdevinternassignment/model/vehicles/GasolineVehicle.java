package org.example.softdevinternassignment.model.vehicles;

public class GasolineVehicle extends VehicleBase {
    public GasolineVehicle(int capacity, int range) {
        super(capacity, range,2,1.f);
    }
    @Override
    public String toString() {
        return "GasolineVehicle" + super.toString();
    }
}
