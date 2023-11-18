package com.hackathon.SmartSurucu.controller;

import com.hackathon.SmartSurucu.service.PenaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PenaltyController {
    @Autowired
    private PenaltyService penaltyService;



}
