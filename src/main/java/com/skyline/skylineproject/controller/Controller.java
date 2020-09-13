package com.skyline.skylineproject.controller;

import com.skyline.skylineproject.api.Request;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping(value = "/select", consumes = "application/json")
    public void select(@RequestBody Request request){
        System.out.println("b");
    }

}
