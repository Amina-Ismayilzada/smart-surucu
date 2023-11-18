package com.hackathon.SmartSurucu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingBehaviourRepository extends JpaRepository<DrivingBehaviourRepository, Long> {
}
