package com.example.rk.hotelmgmt.service;

import com.example.rk.hotelmgmt.dto.MenuItemDto;
import com.example.rk.hotelmgmt.dto.OrderDetailDto;
import com.example.rk.hotelmgmt.dto.OrderHeaderDto;
import com.example.rk.hotelmgmt.dto.StaffDto;
import com.example.rk.hotelmgmt.entity.OrderHeader;
import com.example.rk.hotelmgmt.entity.Staff;
import com.example.rk.hotelmgmt.repository.OrderHeadRepo;
import com.example.rk.hotelmgmt.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    OrderHeadRepo orderHeadRepo;

    @Autowired
    StaffRepo staffRepo;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public OrderHeaderDto getOrder(Integer orderId) throws Exception {
        Optional<OrderHeader> order = orderHeadRepo.findById(orderId);
        if(order.isPresent()) {
            return getOrder(order.get());
        } else {
            throw new Exception("Order not found");
        }
    }

    public OrderHeaderDto getOrder(OrderHeader order) {
        OrderHeaderDto orderHeaderDto = OrderHeaderDto.builder().id(order.getId())
                .staffId(order.getStaffId())
                .name(order.getName())
                .createdDate(order.getCreatedDate())
                .completedDate(order.getCompletedDate()).build();

        List< OrderDetailDto> orderDetailDtoList = new ArrayList<>();
        order.getOrderDetail().stream().forEach(
                o -> orderDetailDtoList.add(OrderDetailDto.builder().id(o.getId()).orderId(order.getId())
                        .qty(o.getQty())
                        .itemId(MenuItemDto.builder().id(o.getItemId().getId())
                                .itemName(o.getItemId().getItemName())
                                .itemPrice(o.getItemId().getItemPrice()).build())
                        .status(o.getStatus())
                        .build()
        ));
        orderHeaderDto.setOrderDetailDtoList(orderDetailDtoList);

        return orderHeaderDto;
    }

    @Transactional
    public Integer getInvoice(Integer orderid) {
        Integer invocie=null;
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("generate_invoice")
                .declareParameters(new SqlParameter[] {
                        new SqlParameter("in_order", Types.INTEGER),
                        new SqlOutParameter("out_invoice",Types.INTEGER)
                });

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("in_order",orderid);

        Map<String, Object> result= simpleJdbcCall.execute(mapSqlParameterSource);
        invocie = (Integer) result.get("out_invoice");

        return invocie;
    }

    @Transactional
    public List<StaffDto> gethighPerStaff(Integer qty) {
        List<Staff> staffList = new ArrayList<>();
        staffList = staffRepo.findPerfStaff(qty);

        List<StaffDto> staffDtos = new ArrayList<>();
        staffList.stream().forEach( o ->
                staffDtos.add(StaffDto.builder().id(o.getId()).firstName(o.getFirstName())
                        .lastName(o.getLastName()).mobile(o.getMobile()).email(o.getEmail()).build()));

        return staffDtos;
    }

}
