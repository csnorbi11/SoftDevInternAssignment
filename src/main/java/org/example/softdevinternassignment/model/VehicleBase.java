package org.example.softdevinternassignment.model;

public abstract class VehicleBase {
    private final int range;
    private final int capacity;
    private final int fuelConsumption;

    public VehicleBase(int capacity, int range, int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        if(capacity<=0){
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        if(range<=0){
            throw new IllegalArgumentException("Range must be greater than 0");
        }
        this.capacity = capacity;
        this.range = range;
    }

    public int getRange(){
        return range;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getRemainingFuel(int distance){
        return range-fuelConsumption*distance;
    }
}
