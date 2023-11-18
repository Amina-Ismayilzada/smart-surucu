package com.hackathon.SmartSurucu.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static com.hackathon.SmartSurucu.model.DrivingStatus.AVERAGE;

@Entity
public class DrivingBehaviour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

//    @Embedded
//    private Location location;
//    private LocalDateTime timestamp;
//    private double currentSpeed;

    @OneToOne(mappedBy = "drivingBehaviour", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Penalty penalty;

    private DrivingStatus status;


    public DrivingBehaviour() {
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

    public DrivingStatus getStatus() {
        return status;
    }

    public void setStatus(DrivingStatus status) {
        this.status = status;
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }
}
