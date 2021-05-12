package com.company;

import java.util.ArrayList;

public class Elevator {
    private int identifier;
    private int current_floor;
    private int direction;

    private ArrayList<Passenger> passengers = new ArrayList<>();

    Elevator(int num){
        setIdentifier(num);
    }

    public void move(){
        setCurrent_floor(current_floor += direction);
        passengers.removeIf(passenger -> (passenger.getFinish_floor() == current_floor));
    }

    public int getIdentifier() {
        return identifier;
    }

    public int getCurrent_floor() {
        return current_floor;
    }

    public int getDirection() {
        return direction;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public void setCurrent_floor(int current_floor) {
        this.current_floor = current_floor;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setPassengers(Passenger passenger) {
        this.passengers.add(passenger);
    }

    @Override
    public String toString () {
        String direction_str = "";

        switch (direction) {
            case -1:
                direction_str = "down";
                break;
            case 1:
                direction_str = "up";
                break;
            default:
                direction_str = "stopped";
                break;
        }

        return  new String("Elevator id: " + identifier + "; Current floor: " + current_floor +
                "; Direction: " + direction_str + "; Number of passenger : " + passengers.size());
    }
}
