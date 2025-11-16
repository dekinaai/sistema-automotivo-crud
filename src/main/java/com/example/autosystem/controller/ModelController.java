package com.example.autosystem.controller;

import com.example.autosystem.entity.VehicleModel;
import com.example.autosystem.repository.ModelRepository;
import com.example.autosystem.repository.BrandRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelController {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelController(ModelRepository modelRepository, BrandRepository brandRepository){
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<VehicleModel> list(){return modelRepository.findAll();}

    @PostMapping
    public ResponseEntity<?> create(@RequestBody VehicleModel model){
        if(model.getBrand() == null || model.getBrand().getId() == null) return ResponseEntity.badRequest().body("brand id required");
        return brandRepository.findById(model.getBrand().getId())
            .map(b -> {
                model.setBrand(b);
                return ResponseEntity.ok(modelRepository.save(model));
            }).orElse(ResponseEntity.badRequest().body("brand not found"));
    }
}
