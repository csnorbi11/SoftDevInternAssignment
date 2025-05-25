package org.example.softdevinternassignment.model.vehicles;

public abstract class VehicleBase {
    protected final int range;
    private final int capacity;

    protected final int refuelCost;

    public VehicleBase(int capacity, int range, int refuelCost) {
        if(capacity<=0){
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        if(range<=0){
            throw new IllegalArgumentException("Range must be greater than 0");
        }
        if(refuelCost<=0){
            throw new IllegalArgumentException("Refuel cost must be greater than 0");
        }
        this.capacity = capacity;
        this.range = range;
        this.refuelCost=refuelCost;
    }

    public int getRange(){
        return range;
    }
    public int getCapacity(){
        return capacity;
    }
    public String getVehicleType(){
        return this.getClass().getSimpleName();
    }
    public abstract int getRemainingFuel(int distance);
    public abstract int getRefuelCost(int distance);
}
