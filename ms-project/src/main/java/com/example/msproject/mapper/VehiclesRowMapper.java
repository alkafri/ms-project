package com.example.msproject.mapper;

import com.example.msproject.model.Vehicles;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehiclesRowMapper implements RowMapper<Vehicles> {
    @Override
    public Vehicles mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vehicles vehicle = new Vehicles();
        vehicle.setId(rs.getInt("id"));
        vehicle.setBrand_name(rs.getString("brand_name"));
        vehicle.setModel_name(rs.getString("model_name"));
        vehicle.setType(rs.getString("type"));
        vehicle.setYear_of_make(rs.getInt("year_of_make"));
        vehicle.setRegistration_number(rs.getString("registration_number"));
        vehicle.setNo_of_seats(rs.getInt("no_of_seats"));
        vehicle.setBelonging_group(rs.getInt("belonging_group"));
        vehicle.setOccupied(rs.getInt("occupied"));
        vehicle.setOccupation_starts(rs.getString("occupation_starts"));
        vehicle.setOccupation_ends(rs.getString("occupation_ends"));
        vehicle.setCurrent_location(rs.getString("current_location"));

        return vehicle;
    }
}


