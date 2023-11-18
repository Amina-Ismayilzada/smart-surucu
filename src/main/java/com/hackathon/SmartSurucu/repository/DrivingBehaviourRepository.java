package com.hackathon.SmartSurucu.repository;

import com.hackathon.SmartSurucu.model.DrivingBehaviour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingBehaviourRepository extends JpaRepository<DrivingBehaviour, Long> {
}
