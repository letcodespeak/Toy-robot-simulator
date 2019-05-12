package com.rea.interview.robot.core;

public class CarLocation {

    private int x;
    private int y;
    private String direction;

    private CarLocation() {
        x = -1;
        y = -1;
        direction = "N/A";
    }

    private static interface Singleton {
        final CarLocation INSTANCE = new CarLocation();
    }

    public static CarLocation getInstance() {
        return Singleton.INSTANCE;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return this.direction;
    }

    public boolean isInitialized() {
        return !(this.x == -1 && this.y == -1 && this.direction.equalsIgnoreCase("N/A"));
    }

    public void reset() {
        x = -1;
        y = -1;
        direction = "N/A";
    }

}
