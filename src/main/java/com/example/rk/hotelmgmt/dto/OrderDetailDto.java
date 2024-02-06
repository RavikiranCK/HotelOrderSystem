package com.example.rk.hotelmgmt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class OrderDetailDto {
    Integer id;

    Integer orderId;

    MenuItemDto itemId;

    Integer qty;
    String status;
    Date createdDate;
    String comments;

}
