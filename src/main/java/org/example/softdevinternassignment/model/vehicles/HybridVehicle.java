package org.example.softdevinternassignment.model.vehicles;

public class HybridVehicle extends VehicleBase {
    public HybridVehicle(int capacity, int range) {
        super(capacity, range);
    }

    @Override
    public int getRemainingFuel(int distance) {
        int consumedFuel=Math.round(distance/2.f);
        return range-consumedFuel;
    }

    @Override
    public int getRefuelCost(int distance) {
        return getRemainingFuel(distance)*(2+1);
    }
}
