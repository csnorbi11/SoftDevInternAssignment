package org.example.softdevinternassignment.model;

public class Trip {
    private final int distance;
    private final int passengerCount;

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
