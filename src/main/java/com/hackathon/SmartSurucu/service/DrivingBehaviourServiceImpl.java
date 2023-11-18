package com.hackathon.SmartSurucu.service;

import com.hackathon.SmartSurucu.model.DrivingBehaviour;
import com.hackathon.SmartSurucu.repository.DrivingBehaviourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrivingBehaviourServiceImpl implements DrivingBehaviorService {
    @Autowired
    private DrivingBehaviourRepository drivingBehaviourRepository;


    @Override
    public DrivingBehaviour saveDrivingBehavior(DrivingBehaviour drivingBehavior) {
        return drivingBehaviourRepository.save(drivingBehavior);
    }
}
