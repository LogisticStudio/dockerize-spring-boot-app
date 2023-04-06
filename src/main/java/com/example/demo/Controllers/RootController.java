package com.example.demo.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    
    public RootController() {

    }

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.status(200).header("Content-Type", "text/html").body(
            "<div style='font-weight:bold; color: tomato;'>" 
            + "Hello From TechThursday"
            + "</div>"
            );
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}
