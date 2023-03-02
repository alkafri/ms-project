package com.example.msproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.msproject.model.Groups;

@Repository("GroupsRepository")
public interface JpaGroupsRepository extends JpaRepository<Groups, Integer> {
}
