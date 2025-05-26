package org.example.softdevinternassignment.model;

import org.example.softdevinternassignment.model.vehicles.VehicleBase;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private final Fleet fleet;

    public Dispatcher() {
        fleet=new Fleet();
    }

    public void addVehicleToFleet(VehicleBase vehicle){
        fleet.addVehicle(vehicle);
    }

    public List<VehicleSuggestion> listVehicles(Trip trip){
        List<VehicleSuggestion> combinations=new ArrayList<>();
        for(VehicleBase vehicle:fleet.getVehicles()){
            if(vehicle.getRange()-trip.getDistance()>=0){
                combinations.add(new VehicleSuggestion(vehicle,calculateProfit(trip,vehicle)));
            }

        }
        return combinations;
    }

    private int calculateProfit(Trip trip, VehicleBase vehicle){
        int poundPerHalfHour=2;
        int distanceFee=trip.getPassengerCount()* trip.getDistance()*poundPerHalfHour;
        int timeFee=trip.getTripTime();
        int refuelCost= vehicle.getRefuelCost(trip.getDistance());

        return distanceFee+timeFee-refuelCost;
    }

}
