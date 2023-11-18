package com.hackathon.SmartSurucu.service;

import com.hackathon.SmartSurucu.model.DrivingBehaviour;
import com.hackathon.SmartSurucu.model.DrivingStatus;
import com.hackathon.SmartSurucu.repository.DrivingBehaviourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DrivingBehaviour updateDrivingBehavior(DrivingBehaviour drivingBehavior){
//        if(drivingBehavior.getStatus() == DrivingStatus.GREAT){
//            if(drivingBehavior.getRadar20Count()>2 ||
//                    drivingBehavior.getRadar40Count()>1 ||
//                    drivingBehavior.getRedLightCount() > 0 ||
//                    drivingBehavior.getDrunkCount() > 0 ||
//                    drivingBehavior.getAccelerationCount()+drivingBehavior.getAbruptStopCount()>100) {
//                drivingBehavior.setStatus(DrivingStatus.GOOD);
//            }
//        }
//        else if(drivingBehavior.getStatus() == DrivingStatus.GOOD){
//            if(drivingBehavior.getRadar20Count()>5 ||
//                    drivingBehavior.getRadar40Count()>2 ||
//                    drivingBehavior.getRedLightCount()>1 ||
//                    drivingBehavior.getDrunkCount()>0 ||
//                    drivingBehavior.getAccelerationCount()+drivingBehavior.getAbruptStopCount()>250) {
//                drivingBehavior.setStatus(DrivingStatus.AVERAGE);
//            }
//            else if(drivingBehavior.getRadar20Count()<2 ||
//                    drivingBehavior.getRadar40Count()<1 ||
//                    drivingBehavior.getRedLightCount() == 0 ||
//                    drivingBehavior.getDrunkCount() == 0 ||
//                    drivingBehavior.getAccelerationCount()+drivingBehavior.getAbruptStopCount()<100) {
//                drivingBehavior.setStatus(DrivingStatus.GREAT);
//            }
//        }
//        else if(drivingBehavior.getStatus() == DrivingStatus.AVERAGE){
//            if(drivingBehavior.getRadar20Count()>10 ||
//                    drivingBehavior.getRadar40Count()>4 ||
//                    drivingBehavior.getRedLightCount()>3 ||
//                    drivingBehavior.getDrunkCount()>1 ||
//                    drivingBehavior.getAccelerationCount()+drivingBehavior.getAbruptStopCount()>500) {
//                drivingBehavior.setStatus(DrivingStatus.BAD);
//            }
//            else if(drivingBehavior.getRadar20Count()<5 && drivingBehavior.getRadar20Count()>2 ||
//                    drivingBehavior.getRadar40Count()<2 && drivingBehavior.getRadar40Count()>1 ||
//                    drivingBehavior.getRedLightCount()<1 && drivingBehavior.getRedLightCount()>0 ||
//                    drivingBehavior.getDrunkCount() == 0 && drivingBehavior.getDrunkCount()>0 ||
//                    drivingBehavior.getAccelerationCount()+drivingBehavior.getAbruptStopCount()<250 &&
//                            drivingBehavior.getAccelerationCount()+drivingBehavior.getAbruptStopCount()>100) {
//                drivingBehavior.setStatus(DrivingStatus.GOOD);
//            }
//        }
//        else if(drivingBehavior.getStatus() == DrivingStatus.BAD){
//            if(drivingBehavior.getRadar20Count()>15 ||
//                    drivingBehavior.getRadar40Count()>7 ||
//                    drivingBehavior.getRedLightCount()>5 ||
//                    drivingBehavior.getDrunkCount()>3 ||
//                    drivingBehavior.getAccelerationCount()+drivingBehavior.getAbruptStopCount()>700) {
//                drivingBehavior.setStatus(DrivingStatus.CRITIC);
//            }
//            else if(drivingBehavior.getRadar20Count()<10 && drivingBehavior.getRadar20Count()>5 ||
//                    drivingBehavior.getRadar40Count() == 3 ||
//                    drivingBehavior.getRedLightCount() == 2 ||
//                    drivingBehavior.getDrunkCount()<1 && drivingBehavior.getDrunkCount()>0 ||
//                    drivingBehavior.getAccelerationCount()+drivingBehavior.getAbruptStopCount()<500 &&
//                            drivingBehavior.getAccelerationCount()+drivingBehavior.getAbruptStopCount()>250) {
//                drivingBehavior.setStatus(DrivingStatus.AVERAGE);
//            }
//        }
//        else if(drivingBehavior.getStatus() == DrivingStatus.CRITIC){
//            if(drivingBehavior.getRadar20Count()<15 && drivingBehavior.getRadar20Count()>10 ||
//                    drivingBehavior.getRadar40Count()<7 && drivingBehavior.getRadar40Count()>4 ||
//                    drivingBehavior.getRedLightCount() == 4 ||
//                    drivingBehavior.getDrunkCount() == 2 ||
//                    drivingBehavior.getAccelerationCount()+drivingBehavior.getAbruptStopCount()<700 &&
//                    drivingBehavior.getAccelerationCount()+drivingBehavior.getAbruptStopCount()>500) {
//                drivingBehavior.setStatus(DrivingStatus.BAD);
//            }
//        }
        return drivingBehavior;
    }

    @Override
    public void deleteDrivingBehaviour(Long id) {
        drivingBehaviourRepository.deleteById(id);
    }


}
