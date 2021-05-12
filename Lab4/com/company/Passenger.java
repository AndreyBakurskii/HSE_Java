package com.company;


public class Passenger {
    private int start_floor, finish_floor;
    private int direction;

    Passenger(int s_floor, int f_floor){
        setStart_floor(s_floor);
        setFinish_floor(f_floor);

        int d = Constants.DestSTOPPED;
        if (s_floor > f_floor) {
            d = Constants.DestDOWN;
        } else if (s_floor < f_floor)
            d = Constants.DestUP;

        setDirection(d);
    }

    public int getDirection() {
        return direction;
    }

    public int getStart_floor() {
        return start_floor;
    }

    public int getFinish_floor() {
        return finish_floor;
    }

    public void setStart_floor(int start_floor) {
        this.start_floor = start_floor;
    }

    public void setFinish_floor(int finish_floor) {
        this.finish_floor = finish_floor;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
