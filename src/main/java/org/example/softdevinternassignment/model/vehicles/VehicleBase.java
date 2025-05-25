package org.example.softdevinternassignment.model.vehicles;

public abstract class VehicleBase {
    protected final int range;
    private final int capacity;
    protected final float consumptionPerKm;
    protected final int refuelCost;

    public VehicleBase(int capacity, int range, int refuelCost, float consumptionPerKm) {
        if(capacity<=0){
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        if(range<=0){
            throw new IllegalArgumentException("Range must be greater than 0");
        }
        if(refuelCost<=0){
            throw new IllegalArgumentException("Refuel cost must be greater than 0");
        }
        if(consumptionPerKm<=0){
            throw new IllegalArgumentException("Fuel consumption must be greater than 0");
        }
        this.capacity = capacity;
        this.range = range;
        this.refuelCost=refuelCost;
        this.consumptionPerKm=consumptionPerKm;
    }

    public final int getRange(){
        return range;
    }
    public final int getCapacity(){
        return capacity;
    }
    public final String getVehicleType(){
        return this.getClass().getSimpleName();
    }
    public int getRefuelCost(int distance) {
        return Math.round(distance*refuelCost*consumptionPerKm);
    }
}
