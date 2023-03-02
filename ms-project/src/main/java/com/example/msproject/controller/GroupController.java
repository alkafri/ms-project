package com.example.msproject.controller;

import com.example.msproject.api.GetRout;
import com.example.msproject.model.Groups;
import com.example.msproject.service.GroupServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupServices groupServices;
    private JdbcTemplate jdbcTemplate;


    @GetMapping("groups")
    public ResponseEntity<List<Groups>> getAllGroups() {
        return ResponseEntity.ok(groupServices.getAll());
    }

    @GetMapping("groups/{memberId}")
    public ResponseEntity<Groups> getGroupsById(@PathVariable int memberId) {
        return ResponseEntity.ok(groupServices.get(memberId));
    }

    /**
     * This method will REGISTER a group walk
     */
    @PostMapping("groups/register/{groupname}")
    public ResponseEntity<Integer> registerGroup(@PathVariable String groupname) throws SQLException {
        String start_point = "ostersund central station";
        String end_point = "malmo centralstation";
        String rout = null;

        /**
         * This code will get the route from individual transport
         * parameter 1 and 2 should be passed as variable, but here writted in code for an example
         */
        GetRout getRout = new GetRout();
        rout = getRout.GetRoutFromAzure("ostersund central station", "malmo centralstation");
        ;
        int lengthInMeters = getRout.getLengthInMeters();
        int travelTimeInSeconds = getRout.getTravelTimeInSeconds();
        int trafficDelayInSeconds = getRout.getTrafficDelayInSeconds();
        int trafficLengthInMeters = getRout.getTrafficLengthInMeters();
        String departureTime = getRout.getDepartureTime();
        String arrivalTime = getRout.getArrivalTime();
        /**
         *
         */
        return ResponseEntity.ok(groupServices.registerGroup(groupname, start_point, end_point));

    }

    /**
     * This method will UN REGISTER a group walk
     */
    @GetMapping("groups/unregister/{gid}")
    public ResponseEntity<Integer> unRegisterGroup(@PathVariable int gid) throws SQLException {
        return ResponseEntity.ok(groupServices.unRegisterGroup(gid));
    }
}
