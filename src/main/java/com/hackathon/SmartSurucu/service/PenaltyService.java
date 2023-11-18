package com.hackathon.SmartSurucu.service;

import com.hackathon.SmartSurucu.model.Penalty;

public interface PenaltyService {
    public Penalty getPenalty(Long id);
    public Penalty savePenalty(Penalty penalty);
    public void deletePenalty(Long id);

}
