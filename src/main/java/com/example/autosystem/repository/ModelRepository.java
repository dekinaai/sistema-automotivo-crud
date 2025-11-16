package com.example.autosystem.repository;

import com.example.autosystem.entity.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ModelRepository extends JpaRepository<VehicleModel, Long> {
    List<VehicleModel> findByBrandId(Long brandId);
}
