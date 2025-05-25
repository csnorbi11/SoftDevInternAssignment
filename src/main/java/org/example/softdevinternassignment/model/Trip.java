package org.example.softdevinternassignment.model;

public class Trip {
    private final int distance;
    private final int passengerCount;
    private boolean onlyCity;

    public Trip(int distance, int passengerCount) {
        this.distance = distance;
        this.passengerCount = passengerCount;
        if(distance<=50){
            onlyCity=true;
        }else{
            onlyCity=false;
        }
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
            int inCityTime=distance*2;
            int outCityDistance=distance-50;
            int outCityTime=outCityDistance;
            return inCityTime+outCityTime;
        }
    }
}
