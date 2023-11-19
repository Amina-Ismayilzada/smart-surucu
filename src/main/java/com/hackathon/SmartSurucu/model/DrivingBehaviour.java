package com.hackathon.SmartSurucu.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

/*
This entity describes the behaviour of the driver on the road such as them getting
different fines, accelerating, abrupt stopping and etc.
 */
@Entity
public class DrivingBehaviour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "driver_id", unique = true)
    private Driver driver;

/*

{
  "driver": {
    "id": 4
  },
  "penalty": {
    "abruptStopCount": 2,
    "accelerationCount": 1,
    "radar20Count": 4,
    "radar40Count": 1,
    "redLightCount": 0,
    "drunkCount": 0
  },
  "status": "GOOD"
}
 */
    @Enumerated(EnumType.STRING)
    private DrivingStatus status;

    private LocalDateTime timestamp;
    private int abruptStopCount;
    private int accelerationCount;
    private int radar20Count;
    private int radar40Count;
    private int redLightCount;
    private int drunkCount;
    private double insuranceCost;



    public DrivingBehaviour() {
        this.timestamp = LocalDateTime.now();
        this.status = DrivingStatus.GREAT;
    }

    public DrivingBehaviour(Long id, Driver driver) {
        this.id = id;
        this.driver = driver;
        this.status = DrivingStatus.GREAT;
        this.timestamp = LocalDateTime.now();
        this.abruptStopCount = 0;
        this.accelerationCount = 0;
        this.radar20Count = 0;
        this.radar40Count = 0;
        this.redLightCount = 0;
        this.drunkCount = 0;
        this.insuranceCost = 130;
    }

    public DrivingBehaviour(Long id, Driver driver, DrivingStatus status, int abruptStopCount, int accelerationCount, int radar20Count, int radar40Count, int redLightCount, int drunkCount, double insuranceCost) {
        this.id = id;
        this.driver = driver;
        this.status = status;
        this.timestamp =  LocalDateTime.now();
        this.abruptStopCount = abruptStopCount;
        this.accelerationCount = accelerationCount;
        this.radar20Count = radar20Count;
        this.radar40Count = radar40Count;
        this.redLightCount = redLightCount;
        this.drunkCount = drunkCount;
        this.insuranceCost = insuranceCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(double insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public DrivingStatus getStatus() {
        return status;
    }

    public void setStatus(DrivingStatus status) {
        this.status = status;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "DrivingBehaviour{" +
                "id=" + id +
                ", driver=" + driver +
                ", status=" + status +
                ", timestamp=" + timestamp +
                ", abruptStopCount=" + abruptStopCount +
                ", accelerationCount=" + accelerationCount +
                ", radar20Count=" + radar20Count +
                ", radar40Count=" + radar40Count +
                ", redLightCount=" + redLightCount +
                ", drunkCount=" + drunkCount +
                ", insuranceCost=" + insuranceCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrivingBehaviour that = (DrivingBehaviour) o;
        return abruptStopCount == that.abruptStopCount && accelerationCount == that.accelerationCount && radar20Count == that.radar20Count && radar40Count == that.radar40Count && redLightCount == that.redLightCount && drunkCount == that.drunkCount && Double.compare(that.insuranceCost, insuranceCost) == 0 && Objects.equals(id, that.id) && Objects.equals(driver, that.driver) && status == that.status && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driver, status, timestamp, abruptStopCount, accelerationCount, radar20Count, radar40Count, redLightCount, drunkCount, insuranceCost);
    }
}
