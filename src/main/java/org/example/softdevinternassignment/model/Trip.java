package org.example.softdevinternassignment.model;

public class Trip {
    private final int distance;
    private final int passengerCount;
    private final boolean onlyCity;
    private final int inCityKm=50;

    public Trip(int distance, int passengerCount) {
        this.distance = distance;
        this.passengerCount = passengerCount;
        onlyCity = distance <= inCityKm;
    }

    public int getDistance() {
        return distance;
    }
    public int getPassengerCount() {
        return passengerCount;
    }
    public int getTripTime(){
        int inCityMinsPerKm = 2;
        if(onlyCity){
            return distance* inCityMinsPerKm;
        }else{
            int remainingDistance=distance-inCityKm;
            int outCityMinsPerKm = 1;
            return inCityKm* inCityMinsPerKm +remainingDistance* outCityMinsPerKm;
        }
    }
}
