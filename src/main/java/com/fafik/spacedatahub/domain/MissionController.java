package com.fafik.spacedatahub.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MissionController {
    private final MissionRepository missionRepository;

    public MissionController(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @GetMapping("/all")
    public List<Mission> getAll(){
        List<Mission> all = missionRepository.findAll();
        return all;
    }
    @GetMapping("/{id}")
    public Mission getAll(@PathVariable Long id){
        Mission mission = missionRepository.findById(id).orElseGet(()->new Mission());
        return mission;
    }
}
