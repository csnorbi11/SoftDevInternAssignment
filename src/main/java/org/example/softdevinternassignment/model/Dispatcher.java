package org.example.softdevinternassignment.model;

import org.example.softdevinternassignment.model.vehicles.VehicleBase;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    record Combination(VehicleBase vehicle, int profit) {
    }

    private final Fleet fleet;

    public Dispatcher() {
        fleet=new Fleet();
    }

    public void addVehicleToFleet(VehicleBase vehicle){
        fleet.addVehicle(vehicle);
    }

    public List<Combination> listVehicles(Trip trip){
        List<Combination> combinations=new ArrayList<Combination>();
        for(VehicleBase vehicle:fleet.getVehicles()){
            combinations.add(new Combination(vehicle,calculateProfit(trip,vehicle)));
        }
        return combinations;
    }

    private int calculateProfit(Trip trip, VehicleBase vehicle){
        int profit=0;
        int distanceFee=trip.getPassengerCount()* trip.getDistance()*2;
        int timeFee=trip.getTripTime();
        int refuelCost= vehicle.getRefuelCost(trip.getDistance());
        profit=distanceFee+timeFee-refuelCost;

        return profit;
    }

}
