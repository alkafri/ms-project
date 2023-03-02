package com.example.msproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter @Getter
public class Members implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String user_name;
    private String user_password;
    private int group_id;

    @Override
    public Members clone() {
        try {
            return (Members) super.clone();
        } catch (CloneNotSupportedException e) {
            Members members = new Members();

            members.setId(this.getId());
            members.setUser_name(this.getUser_name());
            members.setUser_password(this.getUser_password());
            members.setGroup_id(this.getGroup_id());

            return members;
        }
    }
}
