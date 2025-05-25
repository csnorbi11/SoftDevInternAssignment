package org.example.softdevinternassignment.controller;

import org.example.softdevinternassignment.model.Dispatcher;
import org.example.softdevinternassignment.model.Trip;
import org.example.softdevinternassignment.model.VehicleSuggestion;
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


    @PostMapping("/vehicles")
    public ResponseEntity<String> addVehicle(@RequestBody VehicleRequest request){
        VehicleBase vehicle= switch (request.type().toLowerCase()){
            case "gasoline" -> new GasolineVehicle(request.capacity(),request.range());
            case "electric" -> new ElectricVehicle(request.capacity(),request.range());
            case "hybrid" -> new HybridVehicle(request.capacity(),request.range());
            default -> throw new IllegalArgumentException("Invalid vehicle type: "+request.type());

        };
        dispatcher.addVehicleToFleet(vehicle);

        return ResponseEntity.ok("Vehicle added");
    }

    @PostMapping("/suggestions")
    public ResponseEntity<String> listSuggestions(@RequestBody Trip trip){
        return ResponseEntity.ok(dispatcher.listVehicles(trip).toString());
    }
}
