package com.example.rk.hotelmgmt.repository;

import com.example.rk.hotelmgmt.entity.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHeadRepo extends JpaRepository<OrderHeader, Integer> {

    @Procedure(name="generate_invoice")
    void generateInvoice(@Param("in_order") Integer order, @Param("out_invoice") Integer invoice);

}
