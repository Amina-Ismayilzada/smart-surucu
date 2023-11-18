package com.hackathon.SmartSurucu.service;

import com.hackathon.SmartSurucu.model.DrivingBehaviour;

public interface DrivingBehaviorService {
    DrivingBehaviour findById(Long id);
    DrivingBehaviour saveDrivingBehavior(DrivingBehaviour drivingBehavior);
    public DrivingBehaviour updateDrivingBehavior(DrivingBehaviour drivingBehavior);

    void deleteDrivingBehaviour(Long id);
}
