package com.example.msproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Setter @Getter
public class Vehicles implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String brand_name;
    private String model_name;
    private String type;
    private int year_of_make;
    private String registration_number;
    private int no_of_seats;
    private int belonging_group;
    private int occupied;
    private String occupation_starts;
    private String occupation_ends;
    private String current_location;


    @Override
    public Vehicles clone() {
        try {
            return (Vehicles) super.clone();
        } catch (CloneNotSupportedException e) {
            Vehicles vehicles = new Vehicles();

            vehicles.setId(this.getId());
            vehicles.setBrand_name(this.getBrand_name());
            vehicles.setModel_name(this.getModel_name());
            vehicles.setType(this.getType());
            vehicles.setYear_of_make(this.getYear_of_make());
            vehicles.setRegistration_number(this.getRegistration_number());
            vehicles.setNo_of_seats(this.getNo_of_seats());
            vehicles.setBelonging_group(this.getBelonging_group());
            vehicles.setOccupied(this.getOccupied());
            vehicles.setOccupation_starts(this.getOccupation_starts());
            vehicles.setOccupation_ends(this.getOccupation_ends());
            vehicles.setCurrent_location(this.getCurrent_location());

            return vehicles;
        }
    }
}
