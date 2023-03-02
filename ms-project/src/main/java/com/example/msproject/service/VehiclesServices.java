package com.example.msproject.service;

import com.example.msproject.mapper.MembersRowMapper;
import com.example.msproject.mapper.VehiclesRowMapper;
import com.example.msproject.model.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.msproject.model.Vehicles;
import com.example.msproject.repository.JpaVehiclesRepository;

@Service
public class VehiclesServices {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private JpaVehiclesRepository vehiclesRepository;



    public Vehicles get(int id){
        return jdbcTemplate.queryForObject("SELECT id, brand_name, model_name, type, year_of_make, registration_number, no_of_seats, belonging_group, occupied, occupation_starts, occupation_ends, current_location FROM vehicles WHERE id = ?", new Object[] { id },
                new VehiclesRowMapper());
    }
    public List<Vehicles> getAll(){
        return jdbcTemplate.query("SELECT id, brand_name, model_name, type, year_of_make, registration_number, no_of_seats, belonging_group, occupied, occupation_starts, occupation_ends, current_location FROM vehicles", new VehiclesRowMapper());
    }



    public Vehicles save(Vehicles vehicles){return vehiclesRepository.save(vehicles);}
    public void delete (int vehicleId){vehiclesRepository.deleteById(vehicleId);}

    public int addToGroup(int gid, int vid){
        return jdbcTemplate.update("UPDATE vehicles SET belonging_group = ? WHERE id = ?", gid,vid);
    }

    public int removeGroup(int vid){
        return jdbcTemplate.update("UPDATE vehicles SET belonging_group = 0 WHERE id = ?", vid);
    }

    public List<Vehicles> getAllInGroup(int gid){
        return jdbcTemplate.query("SELECT id, brand_name, model_name, type, year_of_make, registration_number, no_of_seats, belonging_group, occupied, occupation_starts, occupation_ends, current_location FROM vehicles WHERE belonging_group = ?", new Object[] { gid }, new VehiclesRowMapper());
    }

    public int changeStatus(String occupiation_starts, String occupation_ends, int vid){
        return jdbcTemplate.update("UPDATE vehicles SET occupied = 1, occupation_starts=?,occupation_ends=? WHERE id = ?", occupiation_starts,occupation_ends,vid);
    }
}
