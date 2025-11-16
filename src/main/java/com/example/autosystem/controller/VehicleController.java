package com.example.autosystem.controller;

import com.example.autosystem.entity.Vehicle;
import com.example.autosystem.repository.VehicleRepository;
import com.example.autosystem.repository.ModelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleRepository vehicleRepository;
    private final ModelRepository modelRepository;

    public VehicleController(VehicleRepository vehicleRepository, ModelRepository modelRepository){
        this.vehicleRepository = vehicleRepository;
        this.modelRepository = modelRepository;
    }

    @GetMapping
    public List<Vehicle> listAll(){ return vehicleRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> get(@PathVariable Long id){
        return vehicleRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Vehicle v){
        if(v.getModel() == null || v.getModel().getId() == null) return ResponseEntity.badRequest().body("model id required");
        return modelRepository.findById(v.getModel().getId()).map(m -> {
            v.setModel(m);
            return ResponseEntity.ok(vehicleRepository.save(v));
        }).orElse(ResponseEntity.badRequest().body("model not found"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody Vehicle in){
        return vehicleRepository.findById(id).map(v -> {
            v.setPrice(in.getPrice());
            v.setMileage(in.getMileage());
            v.setColor(in.getColor());
            v.setStatus(in.getStatus());
            v.setYear(in.getYear());
            return ResponseEntity.ok(vehicleRepository.save(v));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(!vehicleRepository.existsById(id)) return ResponseEntity.notFound().build();
        vehicleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
