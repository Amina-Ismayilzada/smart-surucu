package com.hackathon.SmartSurucu.service;

import com.hackathon.SmartSurucu.model.DrivingBehaviour;
import com.hackathon.SmartSurucu.model.DrivingStatus;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.time.LocalDateTime;

public interface DrivingBehaviorService {
    DrivingBehaviour findById(Long id);
    public DrivingBehaviour updatePenalty(Long id, DrivingBehaviour drivingBehavior, int abruptStopCount, int accelerationCount,
                                          int radar20Count, int radar40Count, int redLightCount, int drunkCount) throws ChangeSetPersister.NotFoundException;
    DrivingBehaviour saveDrivingBehavior(DrivingBehaviour drivingBehavior);
    public DrivingBehaviour updateDrivingBehavior(DrivingBehaviour drivingBehavior, LocalDateTime currentTime);

    void deleteDrivingBehaviour(Long id);
}
