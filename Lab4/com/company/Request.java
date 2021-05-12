package com.company;

import java.util.Random;

public class Request implements Runnable{
    private int amount_floors, number_of_people_on_floor;

    private Manager manager;

    Request (int amount_floors, int number_of_people_on_floor, Manager manager){
        setAmount_floors(amount_floors);
        setNumber_of_people_on_floor(number_of_people_on_floor);
        setManager(manager);
    }

    @Override
    public void run(){

        Random rand = new Random();

        while (true) {
            int number_people = rand.nextInt(number_of_people_on_floor + 1);

            int start_floor = rand.nextInt(amount_floors + 1);
            for (int i = 0; i < number_people; i++) {
                int finish_floor = rand.nextInt(amount_floors + 1);

                while (start_floor == finish_floor) {
                    finish_floor = rand.nextInt(amount_floors + 1);
                }

                manager.setPassengers(new Passenger(start_floor, finish_floor));
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public int getAmount_floors() {
        return amount_floors;
    }

    public int getNumber_of_people_on_floor() {
        return number_of_people_on_floor;
    }

    public Manager getManager() {
        return manager;
    }

    public void setAmount_floors(int amount_floors) {
        this.amount_floors = amount_floors;
    }

    public void setNumber_of_people_on_floor(int number_of_people_on_floor) {
        this.number_of_people_on_floor = number_of_people_on_floor;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
