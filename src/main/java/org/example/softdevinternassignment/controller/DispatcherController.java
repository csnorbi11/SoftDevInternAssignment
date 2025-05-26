package org.example.softdevinternassignment.controller;

import org.example.softdevinternassignment.model.Dispatcher;
import org.example.softdevinternassignment.model.Trip;
import org.example.softdevinternassignment.model.vehicles.ElectricVehicle;
import org.example.softdevinternassignment.model.vehicles.GasolineVehicle;
import org.example.softdevinternassignment.model.vehicles.HybridVehicle;
import org.example.softdevinternassignment.model.vehicles.VehicleBase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DispatcherController {
    private final Dispatcher dispatcher=new Dispatcher();


    @PostMapping("/suggestions")
    public ResponseEntity<String> listSuggestions(@RequestBody Trip trip){
        return ResponseEntity.ok(dispatcher.listVehicles(trip).toString());
    }
}
