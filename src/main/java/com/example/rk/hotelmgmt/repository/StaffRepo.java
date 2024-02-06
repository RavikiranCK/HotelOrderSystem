package com.example.rk.hotelmgmt.repository;

import com.example.rk.hotelmgmt.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Integer> {


    @Query(nativeQuery = true)
    List<Staff> findPerfStaff(@Param("numorder") Integer numorder);
}
