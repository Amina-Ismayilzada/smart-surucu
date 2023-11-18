package com.hackathon.SmartSurucu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String FIN;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "driver_id")
    private List<Car> cars = new ArrayList<>();

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DrivingBehaviour> drivingBehaviour = new ArrayList<>();


    public Driver() {

    }

    public Driver(Long id, String name, String surname, String FIN, String phoneNumber, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.FIN = FIN;
        this.phoneNumber = phoneNumber;
        this.cars = cars;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFIN() {
        return FIN;
    }

    public void setFIN(String FIN) {
        this.FIN = FIN;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<DrivingBehaviour> getDrivingBehaviour() {
        return drivingBehaviour;
    }

    public void setDrivingBehaviour(List<DrivingBehaviour> drivingBehaviour) {
        this.drivingBehaviour = drivingBehaviour;
    }
}
