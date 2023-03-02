package com.example.msproject.controller;

import com.example.msproject.service.MembersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import com.example.msproject.model.Members;

@RestController
public class MembersController {
    @Autowired
    private MembersServices membersServices;
    private JdbcTemplate jdbcTemplate;

    @GetMapping("members")
    public ResponseEntity<List<Members>> getAllMembers() {
        return ResponseEntity.ok(membersServices.getAll());
    }

    @GetMapping("members/{memberId}")
    public ResponseEntity<Members> getMembersById(@PathVariable int memberId) {
        return ResponseEntity.ok(membersServices.get(memberId));
    }


    @PostMapping("members/addtogroup/{mid}/{gid}")
    public ResponseEntity<Integer> updateMember(@PathVariable int mid, @PathVariable int gid) throws SQLException {
        return ResponseEntity.ok(membersServices.addToGroup(gid, mid));
    }


}
