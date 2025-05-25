package org.example.softdevinternassignment.model;

public class Trip {
    private int distance;
    private int passengerCount;

    public Trip(int distance, int passengerCount) {
        this.distance = distance;
        this.passengerCount = passengerCount;
    }



    public int getDistance() {
        return distance;
    }
    public int getPassengerCount() {
        return passengerCount;
    }
}
