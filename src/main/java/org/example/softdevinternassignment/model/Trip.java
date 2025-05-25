package org.example.softdevinternassignment.model;

public class Trip {
    private final int distance;
    private final int passengerCount;
    private final boolean onlyCity;

    public Trip(int distance, int passengerCount) {
        this.distance = distance;
        this.passengerCount = passengerCount;
        onlyCity = distance <= 50;
    }

    public int getDistance() {
        return distance;
    }
    public int getPassengerCount() {
        return passengerCount;
    }
    public int getTripTime(){
        if(onlyCity){
            return distance*2;
        }else{
            return distance;
        }
    }
}
