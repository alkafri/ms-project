package com.example.msproject.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.msproject.model.Members;

public class MembersRowMapper implements RowMapper<Members> {
    @Override
    public Members mapRow(ResultSet rs, int rowNum) throws SQLException {
        Members member = new Members();
        member.setId(rs.getInt("id"));
        member.setUser_name(rs.getString("user_name"));
        member.setUser_password(rs.getString("user_password"));
        member.setGroup_id(rs.getInt("group_id"));

        return member;
    }

}

