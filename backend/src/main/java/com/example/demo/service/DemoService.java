package com.example.demo.service;


import com.example.demo.model.ImageDTO;
import com.example.demo.repo.DemoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    private final DemoRepo demoRepo;

    public DemoService(DemoRepo demoRepo) {
        this.demoRepo = demoRepo;
    }

    public List<ImageDTO> loadImages() {
        return demoRepo.findAll();
    }
}
