package com.example.msproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.msproject.model.Vehicles;

@Repository("VehiclesRepository")
public interface JpaVehiclesRepository extends JpaRepository<Vehicles, Integer>{
}
