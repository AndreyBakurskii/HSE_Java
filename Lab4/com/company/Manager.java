package com.company;

import java.util.ArrayList;

public class Manager implements Runnable{
    private int amount_floors, amount_elevators;
    private int payload;

    private ArrayList<Passenger> passengers = new ArrayList<>();
    private ArrayList<Elevator> elevators = new ArrayList<>();

    Manager(int amount_floors, int payload, int amount_elevators){
        setAmount_floors(amount_floors);
        setPayload(payload);
        setAmount_elevators(amount_elevators);

        for (int i = 1; i <= amount_elevators; i++){
            setElevators(new Elevator(i));
        }
    }

    @Override
    public void run(){
        int iter = 0;
        while (true) {
            iter++;
            int used_elevators = 0;
            System.out.println("Iteration #"+iter);
            
            for (Elevator elevator: elevators) {
                elevator.move();

                int current_floor = elevator.getCurrent_floor();
                
                // доступные места в работающих лифтах
                int available_payload =  used_elevators * payload;

                // если есть место в лифте
                if (payload - elevator.getPassengers().size() > 0) {
                    // люди ожидающие наверху
                    ArrayList<Passenger> UP_Requested = new ArrayList<>();
                    
                    // люди ожидающие внизу
                    ArrayList<Passenger> DOWN_Requested = new ArrayList<>();
                    
                    // люди, которые зайдут сейчас в лифт и направятся вверх
                    ArrayList<Passenger> UP_direction_people = new ArrayList<>();

                    // люди, которые зайдут сейчас в лифт и направятся вниз
                    ArrayList<Passenger> DOWN_direction_people = new ArrayList<>();
                    
                    for (Passenger passenger : getPassengers()) {
                        int passenger_s_floor = passenger.getStart_floor();
                        int passenger_direction = passenger.getDirection();

                        if (passenger_s_floor > current_floor)
                            UP_Requested.add(passenger);

                        else if (passenger_s_floor < current_floor)
                            DOWN_Requested.add(passenger);

                        if (passenger_s_floor == current_floor && passenger_direction == Constants.DestUP) {
                            UP_direction_people.add(passenger);

                        } else if (passenger_s_floor == current_floor && passenger_direction == Constants.DestDOWN) {
                            DOWN_direction_people.add(passenger);
                        }
                    }
                    
                    // основная логика изменения направления лифта
                    if (elevator.getPassengers().size() == 0 || current_floor == amount_floors) {
                        if (elevator.getDirection() == Constants.DestUP && (UP_Requested.size() < available_payload
                                || DOWN_Requested.size() < available_payload)) {
                            elevator.setDirection(Constants.DestSTOPPED);
                        } else if (DOWN_Requested.size() > available_payload || current_floor == amount_floors) {
                            elevator.setDirection(Constants.DestDOWN);
                        }
                    } else if (current_floor == 0) {
                        if (UP_Requested.size() > available_payload) {
                            elevator.setDirection(Constants.DestUP);
                        } else {
                            elevator.setDirection(Constants.DestSTOPPED);
                        }
                    } else {
                        elevator.setDirection(Constants.DestUP);
                    }
                    
                    
                    if (elevator.getDirection() == Constants.DestSTOPPED) {
                        if (UP_direction_people.size() > DOWN_direction_people.size() 
                                && UP_Requested.size() > available_payload) {
                            elevator.setDirection(Constants.DestUP);
                            
                        } else if (UP_direction_people.size() <= DOWN_direction_people.size()
                                && DOWN_Requested.size() > available_payload) {
                            elevator.setDirection(Constants.DestDOWN);
                        }
                    }
                    
                    if (current_floor == amount_floors) {
                        elevator.setDirection(Constants.DestDOWN);
                    }
                    
                    
                    if (current_floor == 0) {
                        elevator.setDirection(Constants.DestUP);
                    }
                    
                    // распределение приоритетных пассажиров в зависимости от текущего направления лифта
                    ArrayList<Passenger> priority_passengers = new ArrayList<>();

                    if (elevator.getDirection() == Constants.DestDOWN) {
                        priority_passengers = DOWN_direction_people;
                    } else if (elevator.getDirection() == Constants.DestUP) {
                        priority_passengers = UP_direction_people;
                    }

                    // "впускаем" приоритетных пассажиров в лифт, пока это возможно
                    while (priority_passengers.size() != 0 && elevator.getPassengers().size() < payload) {
                        elevator.setPassengers(priority_passengers.get(0));
                        passengers.remove(priority_passengers.get(0));
                        priority_passengers.remove(0);
                    }
                // если в лифте нет мест, делаем проверку на корректность дальнейшего направления лифта
                } else {
                    if (current_floor == amount_floors) {
                        elevator.setDirection(Constants.DestDOWN);
                    }
                    if (current_floor == 0) {
                        elevator.setDirection(Constants.DestUP);
                    }
                }
                // увеличиваем счетчик рабочих лифтов
                used_elevators++;
                System.out.println(elevator);
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

    public int getPayload() {
        return payload;
    }

    public int getAmount_elevators() {
        return amount_elevators;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public ArrayList<Elevator> getElevators() {
        return elevators;
    }

    public void setAmount_floors(int amount_floors) {
        this.amount_floors = amount_floors;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public void setAmount_elevators(int amount_elevators) {
        this.amount_elevators = amount_elevators;
    }

    public void setElevators(Elevator elevator) {
        this.elevators.add(elevator);
    }

    public void setPassengers(Passenger passenger) {
        this.passengers.add(passenger);
    }
}
