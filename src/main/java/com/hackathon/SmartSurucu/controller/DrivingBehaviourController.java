package com.hackathon.SmartSurucu.controller;

import com.hackathon.SmartSurucu.model.DrivingBehaviour;
import com.hackathon.SmartSurucu.service.DrivingBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driving")
public class DrivingBehaviourController {

    @Autowired
    private DrivingBehaviorService drivingBehaviorService;

    @PostMapping("/add")
    public DrivingBehaviour addDrivingBehavior(@RequestBody DrivingBehaviour drivingBehavior) {
        return drivingBehaviorService.saveDrivingBehavior(drivingBehavior);
    }

    @PutMapping("/{id}")
    public String updateDrivingBehavior(@PathVariable("id") Long id, @RequestBody DrivingBehaviour drivingBehavior) throws ChangeSetPersister.NotFoundException {
         drivingBehaviorService.updatePenalty(id, drivingBehavior,
                drivingBehavior.getAbruptStopCount(),
                drivingBehavior.getAccelerationCount(),
                drivingBehavior.getRadar20Count(),
                drivingBehavior.getRadar40Count(),
                drivingBehavior.getRedLightCount(),
                drivingBehavior.getDrunkCount());
        return drivingBehaviorService.findById(id).toString();
    }

    @DeleteMapping("/{id}")
    public void deleteDrivingBehaviour(@PathVariable("id") Long id){
        drivingBehaviorService.deleteDrivingBehaviour(id);
    }
}
