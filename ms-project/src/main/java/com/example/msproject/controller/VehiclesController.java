package com.example.msproject.controller;



import com.example.msproject.api.GetRout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import com.example.msproject.model.Vehicles;
import com.example.msproject.service.VehiclesServices;

@RestController
public class VehiclesController {

    @Autowired
    private VehiclesServices vehiclesServices;
   // private GetRout getRout;


    @GetMapping ("vehicles")
    public ResponseEntity<List<Vehicles>> getAllVehicles(){
        return ResponseEntity.ok(vehiclesServices.getAll());
    }

    @GetMapping("vehicles/{vehicleId}")
    public ResponseEntity<Vehicles> getVehiclesById( @PathVariable int vehicleId) {
        return ResponseEntity.ok(vehiclesServices.get(vehicleId));
    }

    /**
     * This method ADDS a vehicle to a group
     */
    @PostMapping("vehicles/addtogroup/{vid}/{gid}")
    public ResponseEntity<Integer> addVehiclesToGroup(@PathVariable int vid, @PathVariable int gid) throws SQLException  {
        return ResponseEntity.ok(vehiclesServices.addToGroup(gid, vid));
    }

    /**
     * This method REMOVES a vehicle to a group
     */
    @PostMapping("vehicles/removegroup/{vid}")
    public ResponseEntity<Integer> removeVehiclesFromGroup(@PathVariable int vid) throws SQLException {
        return ResponseEntity.ok(vehiclesServices.removeGroup( vid));
    }

    /**
     * This method GETS all vehicle belongs to specific group
     */
    @GetMapping("vehicles/allingroup/{groupId}")
    public ResponseEntity<List<Vehicles>> getVehiclesInGroup(@PathVariable int groupId){
        return ResponseEntity.ok(vehiclesServices.getAllInGroup(groupId));
    }

    /**
     * This method CHANGE vehicle status to busy, it also put the starts and ends occupation dates.
     */
    @PostMapping("vehicles/changestatus/{vid}")
    public ResponseEntity<Integer> changeVehicleStatus(@PathVariable int vid) throws SQLException {
        /**
         * This code will get the route from individual transport
         * parameter 1 and 2 should be passed as variable, but  written here in code for testing
         */
        GetRout getRout = new GetRout();
        ResponseEntity<String> rout = ResponseEntity.ok(getRout.GetRoutFromAzure("ostersund central station", "malmo centralstation"));

        int lengthInMeters = getRout.getLengthInMeters();
        int travelTimeInSeconds = getRout.getTravelTimeInSeconds();
        int trafficDelayInSeconds = getRout.getTrafficDelayInSeconds();
        int trafficLengthInMeters = getRout.getTrafficLengthInMeters();
        String departureTime = getRout.getDepartureTime();
        String arrivalTime = getRout.getArrivalTime();
        /**
         *
         */
        return ResponseEntity.ok(vehiclesServices.changeStatus(departureTime, arrivalTime, vid));
    }


}
