

package com.hackathon.SmartSurucu.service;


import com.hackathon.SmartSurucu.model.Driver;
import com.hackathon.SmartSurucu.model.DrivingBehaviour;
import com.hackathon.SmartSurucu.model.DrivingStatus;
import com.hackathon.SmartSurucu.repository.DrivingBehaviourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Service
public class DrivingBehaviourServiceImpl implements DrivingBehaviorService {


    @Autowired
    private DrivingBehaviourRepository drivingBehaviourRepository;


    @Override
    public DrivingBehaviour findById(Long id) {
        return drivingBehaviourRepository.findById(id).get();
    }


    @Override
    public DrivingBehaviour saveDrivingBehavior(DrivingBehaviour drivingBehavior) {
        return drivingBehaviourRepository.save(drivingBehavior);
    }
    @Override
    public DrivingBehaviour updatePenalty(Long id, DrivingBehaviour drivingBehavior, int abruptStopCount, int accelerationCount,
                                          int radar20Count, int radar40Count, int redLightCount, int drunkCount) {
        drivingBehavior = drivingBehaviourRepository.findById(id).get();
        drivingBehavior.setAbruptStopCount(abruptStopCount);
        drivingBehavior.setAccelerationCount(accelerationCount);
        drivingBehavior.setRadar20Count(radar20Count);
        drivingBehavior.setDrunkCount(drunkCount);
        drivingBehavior.setRadar40Count(radar40Count);
        drivingBehavior.setRedLightCount(redLightCount);
        LocalDateTime currentTime = LocalDateTime.now();
        updateDrivingBehavior(drivingBehavior, currentTime);
        return drivingBehavior;
    }

    @Override
    public DrivingBehaviour updateDrivingBehavior(DrivingBehaviour drivingBehavior, LocalDateTime currentTime){
        LocalDateTime behaviorTimestamp = drivingBehavior.getTimestamp();
        
        double finalCost = 0;
        if (ChronoUnit.YEARS.between(behaviorTimestamp, currentTime) <= 1) {
            if (drivingBehavior.getStatus() == DrivingStatus.GREAT) {
                if (drivingBehavior.getRadar20Count() > 2 ||
                        drivingBehavior.getRadar40Count() > 1 ||
                        drivingBehavior.getRedLightCount() > 0 ||
                        drivingBehavior.getDrunkCount() > 0 ||
                        drivingBehavior.getAccelerationCount() + drivingBehavior.getAbruptStopCount() > 100) {
                    drivingBehavior.setStatus(DrivingStatus.GOOD);
                }
            } else if (drivingBehavior.getStatus() == DrivingStatus.GOOD) {
                if (drivingBehavior.getRadar20Count() > 5 ||
                        drivingBehavior.getRadar40Count() > 2 ||
                        drivingBehavior.getRedLightCount() > 1 ||
                        drivingBehavior.getDrunkCount() > 0 ||
                        drivingBehavior.getAccelerationCount() + drivingBehavior.getAbruptStopCount() > 250) {

                    drivingBehavior.setStatus(DrivingStatus.AVERAGE);
                } else if (drivingBehavior.getRadar20Count() < 2 ||
                        drivingBehavior.getRadar40Count() < 1 ||
                        drivingBehavior.getRedLightCount() == 0 ||
                        drivingBehavior.getDrunkCount() == 0 ||
                        drivingBehavior.getAccelerationCount() + drivingBehavior.getAbruptStopCount() < 100) {

                    drivingBehavior.setStatus(DrivingStatus.GREAT);
                }
            } else if (drivingBehavior.getStatus() == DrivingStatus.AVERAGE) {
                if (drivingBehavior.getRadar20Count() > 10 ||
                        drivingBehavior.getRadar40Count() > 4 ||
                        drivingBehavior.getRedLightCount() > 3 ||
                        drivingBehavior.getDrunkCount() > 1 ||
                        drivingBehavior.getAccelerationCount() + drivingBehavior.getAbruptStopCount() > 500) {

                    drivingBehavior.setStatus(DrivingStatus.BAD);
                } else if (drivingBehavior.getRadar20Count() < 5 && drivingBehavior.getRadar20Count() > 2 ||
                        drivingBehavior.getRadar40Count() < 2 && drivingBehavior.getRadar40Count() > 1 ||
                        drivingBehavior.getRedLightCount() < 1 && drivingBehavior.getRedLightCount() > 0 ||
                        drivingBehavior.getDrunkCount() == 0 && drivingBehavior.getDrunkCount() > 0 ||
                        drivingBehavior.getAccelerationCount() + drivingBehavior.getAbruptStopCount() < 250 &&
                                drivingBehavior.getAccelerationCount() + drivingBehavior.getAbruptStopCount() > 100) {
                    drivingBehavior.setStatus(DrivingStatus.GOOD);
                }
            } else if (drivingBehavior.getStatus() == DrivingStatus.BAD) {
                if (drivingBehavior.getRadar20Count() > 15 ||
                        drivingBehavior.getRadar40Count() > 7 ||
                        drivingBehavior.getRedLightCount() > 5 ||
                        drivingBehavior.getDrunkCount() > 3 ||
                        drivingBehavior.getAccelerationCount() + drivingBehavior.getAbruptStopCount() > 700) {
                    drivingBehavior.setStatus(DrivingStatus.CRITIC);
                } else if (drivingBehavior.getRadar20Count() < 10 && drivingBehavior.getRadar20Count() > 5 ||
                        drivingBehavior.getRadar40Count() == 3 ||
                        drivingBehavior.getRedLightCount() == 2 ||
                        drivingBehavior.getDrunkCount() < 1 && drivingBehavior.getDrunkCount() > 0 ||
                        drivingBehavior.getAccelerationCount() + drivingBehavior.getAbruptStopCount() < 500 &&
                                drivingBehavior.getAccelerationCount() + drivingBehavior.getAbruptStopCount() > 250) {
                    drivingBehavior.setStatus(DrivingStatus.AVERAGE);
                }
            } else if (drivingBehavior.getStatus() == DrivingStatus.CRITIC) {
                if (drivingBehavior.getRadar20Count() < 15 && drivingBehavior.getRadar20Count() > 10 ||
                        drivingBehavior.getRadar40Count() < 7 && drivingBehavior.getRadar40Count() > 4 ||
                        drivingBehavior.getRedLightCount() == 4 ||
                        drivingBehavior.getDrunkCount() == 2 ||
                        drivingBehavior.getAccelerationCount() + drivingBehavior.getAbruptStopCount() < 700 &&
                                drivingBehavior.getAccelerationCount() + drivingBehavior.getAbruptStopCount() > 500) {
                    drivingBehavior.setStatus(DrivingStatus.BAD);
                }
            }
        } else {
            drivingBehavior.setRadar20Count(0);
            drivingBehavior.setRadar40Count(0);
            drivingBehavior.setRedLightCount(0);
            drivingBehavior.setDrunkCount(0);
            drivingBehavior.setAccelerationCount(0);
            drivingBehavior.setAbruptStopCount(0);


            if(drivingBehavior.getStatus()== DrivingStatus.GREAT){
                finalCost = drivingBehavior.getInsuranceCost()*0.1 + drivingBehavior.getInsuranceCost();
            } else if(drivingBehavior.getStatus()== DrivingStatus.GOOD){
                finalCost = drivingBehavior.getInsuranceCost()*0.05 + drivingBehavior.getInsuranceCost();
            } else if(drivingBehavior.getStatus()== DrivingStatus.AVERAGE){
                finalCost = drivingBehavior.getInsuranceCost();
            } else if(drivingBehavior.getStatus()== DrivingStatus.BAD){
                finalCost = drivingBehavior.getInsuranceCost()*0.95;
            } else if(drivingBehavior.getStatus()== DrivingStatus.CRITIC){
                finalCost = drivingBehavior.getInsuranceCost()*0.9;
            }
            drivingBehavior.setInsuranceCost(finalCost);


        }

        return drivingBehavior;
    }


    @Override
    public void deleteDrivingBehaviour(Long id) {
        drivingBehaviourRepository.deleteById(id);
    }

    @Override
    public DrivingBehaviour getDrivingBehaviourById(Long id) {
        return drivingBehaviourRepository.findById(id).get();
    }


}
