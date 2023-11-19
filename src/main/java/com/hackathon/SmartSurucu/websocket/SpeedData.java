package com.hackathon.SmartSurucu.websocket;

public class SpeedData  {
    private double speed;
    private long driverId;

    public SpeedData(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }
}
