package com.example.msproject.service;

import com.example.msproject.mapper.MembersRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.msproject.model.Members;
import com.example.msproject.repository.JpaMembersRepository;

@Service

public class MembersServices {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private JpaMembersRepository membersRepository;

    public Members get(int id){
        return jdbcTemplate.queryForObject("select id,user_name,user_password,group_id FROM members WHERE id = ?", new Object[] { id },
                new MembersRowMapper());
    }
    public List<Members> getAll(){
        return jdbcTemplate.query("SELECT id,user_name,user_password,group_id FROM members", new MembersRowMapper());
    }

    public int addToGroup(int gid, int mid){
        return jdbcTemplate.update("UPDATE members SET group_id = ? WHERE id = ?", gid,mid);
    }

}
