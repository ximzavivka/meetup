package com.example.demo.controller;

import com.example.demo.model.ImageDTO;
import com.example.demo.service.DemoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }
    @CrossOrigin
    @GetMapping("/images")
    @ResponseStatus(HttpStatus.OK)
    List<ImageDTO> loadGallery() {
        return demoService.loadImages();
    }
}
