package com.example.rk.hotelmgmt.repository;

import com.example.rk.hotelmgmt.entity.MenuItem;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Integer>  {

    List<MenuItem> findByItemNameContaining(String name, Sort sort);

    @Query("select mi from MenuItem mi where mi.itemName = ?1")
    List<MenuItem> findByItemNameQuery(String itemName);

}
