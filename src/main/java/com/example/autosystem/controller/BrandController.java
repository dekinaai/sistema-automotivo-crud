package com.example.autosystem.controller;

import com.example.autosystem.entity.Brand;
import com.example.autosystem.repository.BrandRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository){this.brandRepository = brandRepository;}

    @GetMapping
    public List<Brand> list(){return brandRepository.findAll();}

    @PostMapping
    public Brand create(@RequestBody Brand brand){return brandRepository.save(brand);}

    @PutMapping("/{id}")
    public ResponseEntity<Brand> update(@PathVariable Long id, @RequestBody Brand in){
        return brandRepository.findById(id).map(b -> {
            b.setName(in.getName());
            return ResponseEntity.ok(brandRepository.save(b));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(!brandRepository.existsById(id)) return ResponseEntity.notFound().build();
        brandRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
