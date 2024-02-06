package com.example.rk.hotelmgmt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MenuItemDto {
    Integer id;
    String itemName;
    Integer itemPrice;
    String isActive;
}
