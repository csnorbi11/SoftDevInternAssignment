package org.example.softdevinternassignment.model;

import org.example.softdevinternassignment.model.vehicles.VehicleBase;

public class Dispatcher {

    Fleet fleet;

    public Dispatcher() {
        fleet=new Fleet();
    }

    public int calculateProfit(Trip trip, VehicleBase vehicle){
        int profit=0;
        int distanceFee=trip.getPassengerCount()* trip.getDistance()*2;
        int timeFee=trip.getTripTime();
        int refuelCost= vehicle.getRefuelCost(trip.getDistance());
        profit=distanceFee+timeFee-refuelCost;

        return profit;
    }

}
