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
public class Groups implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String group_name;
    private String start_point;
    private String end_point;

    @Override
    public Groups clone() {
        try {
            return (Groups) super.clone();
        } catch (CloneNotSupportedException e) {
            Groups groups = new Groups();

            groups.setId(this.getId());
            groups.setGroup_name(this.getGroup_name());
            groups.setStart_point(this.getStart_point());
            groups.setEnd_point(this.getEnd_point());

            return groups;
        }
    }
}
