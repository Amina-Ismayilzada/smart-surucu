package com.hackathon.SmartSurucu.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class DrivingBehaviour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Embedded
    private Location location;
    private LocalDateTime timestamp;
    private double currentSpeed;



}
