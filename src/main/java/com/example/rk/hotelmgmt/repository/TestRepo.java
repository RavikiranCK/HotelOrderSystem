package com.example.rk.hotelmgmt.repository;

import com.example.rk.hotelmgmt.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface TestRepo extends JpaRepository<Test, String> {

}
