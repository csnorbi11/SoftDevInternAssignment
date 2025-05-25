package org.example.softdevinternassignment.model;

import org.example.softdevinternassignment.model.vehicles.VehicleBase;

public class Dispatcher {

    private final Fleet fleet;

    public Dispatcher() {
        fleet=new Fleet();
    }

    public VehicleBase suggestVehicle(Trip trip){
        VehicleBase bestOption=fleet.getVehicles().getFirst();
        for(VehicleBase vehicle:fleet.getVehicles()){
            if(calculateProfit(trip,vehicle)>calculateProfit(trip,bestOption)){
                bestOption=vehicle;
            }
        }
        return bestOption;
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
