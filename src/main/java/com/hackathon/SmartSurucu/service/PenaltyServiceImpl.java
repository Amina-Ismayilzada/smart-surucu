package com.hackathon.SmartSurucu.service;

import com.hackathon.SmartSurucu.model.DrivingBehaviour;
import com.hackathon.SmartSurucu.model.Penalty;
import com.hackathon.SmartSurucu.repository.PenaltyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PenaltyServiceImpl implements PenaltyService{
    private final DrivingBehaviorService drivingBehaviorService;
    @Autowired
    private PenaltyRepository penaltyRepository;


    @Override
    public Penalty getPenalty(Long id) {
        return penaltyRepository.findById(id).get();
    }

    @Override
    public Penalty savePenalty(Penalty penalty) {
        penaltyRepository.save(penalty);
        DrivingBehaviour drivingBehaviour =penalty.getDrivingBehaviour();
        drivingBehaviorService.updateDrivingBehavior(drivingBehaviour);
        penalty.setDrivingBehaviour(drivingBehaviour);

        return penalty;
    }

    @Override
    public void deletePenalty(Long id) {
        penaltyRepository.deleteById(id);
    }
}
