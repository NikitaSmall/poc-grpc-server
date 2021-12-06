package com.example.poc.controller;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.poc.config.Config.INSTRUMENTATION_NAME_CONTROLLER;

@RestController
public class ServerController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        Span span = GlobalOpenTelemetry.get().getTracer(INSTRUMENTATION_NAME_CONTROLLER).spanBuilder("received the http request").startSpan();
        span.addEvent("received name parameter: " + name);
        span.end();
        return "{\"message\": \"Hello " + name + "\"}";
    }
}
