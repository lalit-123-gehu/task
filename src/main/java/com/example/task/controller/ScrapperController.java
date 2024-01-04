package com.example.task.controller;

import com.example.task.service.JustDialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ScrapperController {


    @Autowired
     JustDialService justDial;

    @GetMapping("/scrap/just-dial")
    public Map<String, Object> scrapJustDial(){
        return justDial.scrapJustDial();
    }
}
