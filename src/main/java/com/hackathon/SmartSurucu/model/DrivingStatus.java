package com.hackathon.SmartSurucu.model;

import lombok.Getter;

/*
Based on the driver behaviour (the amount of rule breakings), the driver will have certain
status that will either increase or decrease their insurance cost
 */
public enum DrivingStatus {
    GREAT("Əla"),
    GOOD("Yaxşı"),
    AVERAGE("Orta"),
    BAD("Pis"),
    CRITIC("Kritik");

    @Getter
    private String name;

    DrivingStatus(String name) {
        this.name = name;
    }

}
