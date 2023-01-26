package com.example.demo2.cntrl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/welcome")
public class Cntrl {

    @GetMapping
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("welcome !");
    }

    @GetMapping("/goodBye")
    public ResponseEntity<String> goodBye(){
        return ResponseEntity.ok("goodBye !");
    }
}
