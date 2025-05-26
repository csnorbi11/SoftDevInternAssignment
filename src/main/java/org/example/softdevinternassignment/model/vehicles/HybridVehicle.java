package org.example.softdevinternassignment.model.vehicles;

public class HybridVehicle extends VehicleBase {

    public HybridVehicle(int capacity, int range) {
        super(capacity, range, 3,1.f);

    }

    @Override
    public int getRefuelCost(int distance) {
        int inCityKm = 50;
        if(distance<= inCityKm){
            return super.getRefuelCost(distance);
        }else{
            int remainingDistance=distance- inCityKm;
            float inCityConsumption = 0.5f;
            return super.getRefuelCost(inCityKm)+Math.round(remainingDistance* inCityConsumption);
        }
    }

    @Override
    public String toString() {
        return "HybridVehicle" + super.toString();
    }
}
