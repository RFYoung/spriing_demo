package com.example.demo.repository;

import com.example.demo.model.InfectRec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Table(name = "infect_rec")
@Repository
public interface InfectRecRepository<T extends InfectRec> extends JpaRepository<InfectRec, Integer> {
    @Query(value = "SELECT max(id) FROM infect_rec",nativeQuery=true)
    int getMaxId();
}
