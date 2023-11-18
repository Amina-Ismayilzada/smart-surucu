package com.hackathon.SmartSurucu.model;

import jakarta.persistence.*;

@Entity
public class Penalty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int abruptStopCount;
    private int accelerationCount;
    private int radar20Count;
    private int radar40Count;
    private int redLightCount;
    private int drunkCount;

    @OneToOne
    @JoinColumn(name = "driving_behaviour_id", unique = true)
    private DrivingBehaviour drivingBehaviour;

    public Penalty() {
    }

    public Penalty(Long id, int abruptStopCount, int accelerationCount, int radar20Count, int radar40Count, int redLightCount, int drunkCount) {
        this.id = id;
        this.abruptStopCount = abruptStopCount;
        this.accelerationCount = accelerationCount;
        this.radar20Count = radar20Count;
        this.radar40Count = radar40Count;
        this.redLightCount = redLightCount;
        this.drunkCount = drunkCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAbruptStopCount() {
        return abruptStopCount;
    }

    public void setAbruptStopCount(int abruptStopCount) {
        this.abruptStopCount = abruptStopCount;
    }

    public int getAccelerationCount() {
        return accelerationCount;
    }

    public void setAccelerationCount(int accelerationCount) {
        this.accelerationCount = accelerationCount;
    }

    public int getRadar20Count() {
        return radar20Count;
    }

    public void setRadar20Count(int radar20Count) {
        this.radar20Count = radar20Count;
    }

    public int getRadar40Count() {
        return radar40Count;
    }

    public void setRadar40Count(int radar40Count) {
        this.radar40Count = radar40Count;
    }

    public int getRedLightCount() {
        return redLightCount;
    }

    public void setRedLightCount(int redLightCount) {
        this.redLightCount = redLightCount;
    }

    public int getDrunkCount() {
        return drunkCount;
    }

    public void setDrunkCount(int drunkCount) {
        this.drunkCount = drunkCount;
    }

    public DrivingBehaviour getDrivingBehaviour() {
        return drivingBehaviour;
    }

    public void setDrivingBehaviour(DrivingBehaviour drivingBehaviour) {
        this.drivingBehaviour = drivingBehaviour;
    }
}
