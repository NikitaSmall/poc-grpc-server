package com.example.poc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.poc.PocServerApplication.logger;

@RestController
public class ServerController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        logger.info("received the http request");
        logger.info("received name parameter: " + name);
        return "{\"message\": \"Hello " + name + "\"}";
    }
}
