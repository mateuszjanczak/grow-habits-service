package com.mateuszjanczak.growhabits.server.web;

import com.mateuszjanczak.growhabits.server.dto.RollRequest;
import com.mateuszjanczak.growhabits.server.dto.RollResponse;
import com.mateuszjanczak.growhabits.server.service.RollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class WheelController {

    private final RollService rollService;

    public WheelController(RollService rollService) {
        this.rollService = rollService;
    }

    @CrossOrigin
    @PostMapping("/roll")
    public ResponseEntity<RollResponse> roll(@RequestBody @Valid RollRequest rollRequest) {
        RollResponse rollResponse = rollService.roll(rollRequest);
        return new ResponseEntity<>(rollResponse, HttpStatus.OK);
    }

}
