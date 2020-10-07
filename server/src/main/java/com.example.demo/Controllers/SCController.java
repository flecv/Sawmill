package com.example.demo.Controllers;

import com.example.demo.Services.Classes.SalesControllerClass.SalesController;
import com.example.demo.Services.ServiceRealisation.SalesControllerService.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SalesController")
public class SCController {
    private final SCService service;

    @Autowired
    public SCController(SCService service)
    {
        this.service=service;
    }
    @PostMapping()
    public ResponseEntity<SalesController> create(@RequestParam String name, @RequestParam int balance)
    {
        return ResponseEntity.ok(service.createSC(name, balance));
    }
    @GetMapping
    public ResponseEntity<String> report()
    {
        return ResponseEntity.ok(service.SCReport());
    }

}
