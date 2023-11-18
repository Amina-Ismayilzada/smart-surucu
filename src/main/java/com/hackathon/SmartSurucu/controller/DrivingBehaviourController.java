package com.hackathon.SmartSurucu.controller;

import com.hackathon.SmartSurucu.model.DrivingBehaviour;
import com.hackathon.SmartSurucu.service.DrivingBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DrivingBehaviour updateDrivingBehavior(@PathVariable("id") Long id, @RequestBody DrivingBehaviour drivingBehavior) {
        return drivingBehaviorService.updateDrivingBehavior(drivingBehavior);
    }

    @DeleteMapping("/{id}")
    public void deleteDrivingBehaviour(@PathVariable("id") Long id){
        drivingBehaviorService.deleteDrivingBehaviour(id);
    }
}
