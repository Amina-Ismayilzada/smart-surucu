package com.hackathon.SmartSurucu.model;

import lombok.Getter;

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
