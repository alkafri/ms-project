package com.example.msproject.service;

import com.example.msproject.mapper.GroupsRowMapper;
import com.example.msproject.model.Groups;
import com.example.msproject.repository.JpaGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServices {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private JpaGroupsRepository groupsRepository;

    public Groups get(int id){
        return jdbcTemplate.queryForObject("select id,group_name,start_point,end_point FROM groups WHERE id = ?", new Object[] { id },
                new GroupsRowMapper());
    }
    public List<Groups> getAll(){
        return jdbcTemplate.query("SELECT id,group_name,start_point,end_point FROM groups", new GroupsRowMapper());
    }

    public int registerGroup(String group_name, String start_point, String end_point){
        return jdbcTemplate.update("INSERT INTO groups (group_name, start_point, end_point) VALUES (?,?,?)", group_name,start_point,end_point);
    }

    public int unRegisterGroup( int gid){
        return jdbcTemplate.update("DELETE FROM groups WHERE id = ?", gid);
    }
}
