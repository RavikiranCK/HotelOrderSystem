package com.example.rk.hotelmgmt.controller;

import com.example.rk.hotelmgmt.dto.OrderHeaderDto;
import com.example.rk.hotelmgmt.dto.ResponseEntity;
import com.example.rk.hotelmgmt.dto.StaffDto;
import com.example.rk.hotelmgmt.entity.OrderHeader;
import com.example.rk.hotelmgmt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {


    @Autowired
    OrderService orderSvc;

    @RequestMapping("/order")
    public ResponseEntity<OrderHeader> getOrder(@RequestParam Integer orderId) {
        try {
            OrderHeaderDto order = orderSvc.getOrder(orderId);
            ResponseEntity response = new ResponseEntity();
            response.setData(order);
            response.setStatus(HttpStatus.OK);
            return response;
        } catch (Exception e) {
            ResponseEntity response = new ResponseEntity();
            response.setMsg("Order not found");
            response.setStatus(HttpStatus.BAD_REQUEST);
            return response;
        }
    }

    @RequestMapping("/invoice")
    public ResponseEntity<OrderHeader> getInvoice(@RequestParam Integer orderId) {
        try {
            Integer order = orderSvc.getInvoice(orderId);
            ResponseEntity response = new ResponseEntity();
            response.setData(order);
            response.setStatus(HttpStatus.OK);
            return response;
        } catch (Exception e) {
            ResponseEntity response = new ResponseEntity();
            response.setMsg("Order not found");
            response.setStatus(HttpStatus.BAD_REQUEST);
            return response;
        }
    }

    @RequestMapping("/staffwithmoreorder")
    public ResponseEntity<OrderHeader> staffWithMoreOrder(@Param("qty") Integer qty) {
        try {
            List<StaffDto> staffDtos = orderSvc.gethighPerStaff(qty);
            ResponseEntity response = new ResponseEntity();
            response.setData(staffDtos);
            response.setStatus(HttpStatus.OK);
            return response;
        } catch (Exception e) {
            ResponseEntity response = new ResponseEntity();
            response.setMsg("Staff Detail not found");
            response.setStatus(HttpStatus.BAD_REQUEST);
            return response;
        }
    }

}
