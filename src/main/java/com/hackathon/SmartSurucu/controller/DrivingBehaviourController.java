package com.hackathon.SmartSurucu.controller;

import com.hackathon.SmartSurucu.model.DrivingBehaviour;
import com.hackathon.SmartSurucu.service.DrivingBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driving")
public class DrivingBehaviourController {

    @Autowired
    private DrivingBehaviorService drivingBehaviorService;

//    @PostMapping("/add")
//    public ResponseEntity<String> addDrivingBehavior(@RequestBody DrivingBehaviour drivingBehavior) {
//        drivingBehaviorService.saveDrivingBehavior(drivingBehavior);
//        return new ResponseEntity<>("Driving behavior data added successfully", HttpStatus.CREATED);
//    }
}
