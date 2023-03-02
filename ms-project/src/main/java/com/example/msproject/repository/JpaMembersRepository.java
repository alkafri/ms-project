package com.example.msproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.msproject.model.Members;

@Repository("MembersRepository")
public interface JpaMembersRepository extends JpaRepository<Members, Integer>{
}
