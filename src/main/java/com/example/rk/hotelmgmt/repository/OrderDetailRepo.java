package com.example.rk.hotelmgmt.repository;

import com.example.rk.hotelmgmt.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {

}
