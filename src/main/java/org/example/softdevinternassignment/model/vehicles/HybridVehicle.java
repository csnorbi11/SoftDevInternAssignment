package org.example.softdevinternassignment.model.vehicles;

public class HybridVehicle extends VehicleBase {
    public HybridVehicle(int capacity, int range) {
        super(capacity, range, 3,1.f);

    }

    @Override
    public int getRefuelCost(int distance) {
        if(distance<=50){
            return super.getRefuelCost(distance);
        }else{
            int remainingDistance=distance-50;
            return super.getRefuelCost(50)+Math.round(remainingDistance*0.5f);
        }
    }

    @Override
    public String toString() {
        return "HybridVehicle" + super.toString();
    }
}
