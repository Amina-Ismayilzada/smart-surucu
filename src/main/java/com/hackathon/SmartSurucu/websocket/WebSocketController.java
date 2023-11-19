package com.hackathon.SmartSurucu.websocket;
import com.hackathon.SmartSurucu.service.DrivingBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WebSocketController {

    // Map to store speed history for each driver
    private static final Map<Long, List<Double>> speedHistoryMap = new HashMap<>();
    private static final double SPEED_THRESHOLD = 5.0; // Set your desired threshold
    private int abruptStopCount = 0;
    private int accelerationCount = 0;
    @Autowired
    DrivingBehaviorService drivingBehaviorService;

    @MessageMapping("/sendSpeed")
    @SendTo("/topic/speed")
    public List<Double> sendSpeed(SpeedData speedData) {
        long driverId = speedData.getDriverId();
        speedHistoryMap.computeIfAbsent(driverId, k -> new ArrayList<>()).add(speedData.getSpeed());

        if (speedHistoryMap.get(driverId).size() >= 2) {
            // Calculate the difference between the last two speeds
            List<Double> driverSpeedHistory = speedHistoryMap.get(driverId);
            double lastSpeed = driverSpeedHistory.get(driverSpeedHistory.size() - 2);
            double speedDifference = speedData.getSpeed() - lastSpeed;

            //Check if the speed difference exceeds the threshold
            if (Math.abs(speedDifference) > SPEED_THRESHOLD) {
                //Perform your action for a significant speed change
                if (speedDifference > 0) {
                    accelerationCount++;
                    drivingBehaviorService.findById(driverId).setAccelerationCount(accelerationCount);
                } else {
                    abruptStopCount++;
                    drivingBehaviorService.findById(driverId).setAbruptStopCount(abruptStopCount);
                }
            }
        }
        return speedHistoryMap.get(driverId);
    }
}
