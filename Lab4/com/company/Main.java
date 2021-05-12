package com.company;

public class Main {

    public static void main(String[] args) {

    // кол-во лифтов
    int elevators_number = 4;

    // вместимость внутри лифта
    int payload = 5;

    // кол-во этажей
    int amount_floors = 10;

    // максимальное число людей на этаже
    int number_of_people_on_floor = 7;

    // Manager(int amount_floors, int payload, int amount_elevators)
    Manager manager = new Manager(amount_floors, payload, elevators_number);

    // Request(int amount_floors, int number_of_people_on_floor, Manager manager)
    Request request = new Request(amount_floors, number_of_people_on_floor, manager);

    Thread requestsThread = new Thread(request);
    Thread elevatorsThread = new Thread(manager);
    requestsThread.start();
    elevatorsThread.start();
    }
}
