package com.mateuszjanczak.growhabits.server.service;

import com.mateuszjanczak.growhabits.server.dto.RollRequest;
import com.mateuszjanczak.growhabits.server.dto.RollResponse;

public interface RollService {
    RollResponse roll(RollRequest rollRequest);
}
