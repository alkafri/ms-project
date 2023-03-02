package com.example.msproject.mapper;

import com.example.msproject.model.Groups;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupsRowMapper implements RowMapper<Groups>{
    @Override
    public Groups mapRow(ResultSet rs, int rowNum) throws SQLException {
        Groups group = new Groups();
        group.setId(rs.getInt("id"));
        group.setGroup_name(rs.getString("group_name"));
        group.setStart_point(rs.getString("start_point"));
        group.setEnd_point(rs.getString("end_point"));

        return group;
    }
}



