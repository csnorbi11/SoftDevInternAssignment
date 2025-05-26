package org.example.softdevinternassignment.controller;

import org.example.softdevinternassignment.model.Dispatcher;
import org.example.softdevinternassignment.model.Fleet;
import org.example.softdevinternassignment.model.Trip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class DispatcherController {
    private final Dispatcher dispatcher;

    public DispatcherController(Fleet fleet) {
        this.dispatcher=new Dispatcher(fleet);
    }


    @PostMapping("/suggestions")
    public ResponseEntity<String> listSuggestions(@RequestBody Trip trip){
        return ResponseEntity.ok(dispatcher.listVehicles(trip).toString());
    }
}
