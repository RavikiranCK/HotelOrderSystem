package com.example.rk.hotelmgmt.service;

import com.example.rk.hotelmgmt.dto.MenuItemDto;
import com.example.rk.hotelmgmt.entity.MenuItem;
import com.example.rk.hotelmgmt.entity.MenuItemMapper;
import com.example.rk.hotelmgmt.repository.MenuItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuItemRepo menuItemRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public MenuItemDto createMenuItem(MenuItemDto itemDto) throws Exception {
        //Validate the metadata
        //ToDO

        List<MenuItem> itemEntExists = menuItemRepo.findByItemNameContaining(itemDto.getItemName(),Sort.by(Sort.Direction.ASC, "itemName"));
        if(itemEntExists != null && itemEntExists.size() > 0) {
            throw new Exception("This item already exists");
        }

        MenuItem item = MenuItem.builder().itemName(itemDto.getItemName()).itemPrice(itemDto.getItemPrice())
                .isActive(itemDto.getIsActive()).build();
        MenuItem itemEnt = menuItemRepo.save(item);
        itemDto.setId(itemEnt.getId());
        return itemDto;
    }

    public List<MenuItemDto> getmatchingByJPA(String itemName) {
        List<MenuItem> menuItems = menuItemRepo.findByItemNameContaining(itemName,Sort.by(Sort.Direction.ASC, "itemName"));
        return convertMenuItemEntToDto(menuItems);
    }

    public List<MenuItemDto> getMatchingItemByQuery(String itemName) {
        List<MenuItem> menuItems = menuItemRepo.findByItemNameQuery(itemName);
        return convertMenuItemEntToDto(menuItems);
    }

    public List<MenuItemDto> getMatchingItemByJdbc(String itemName) {
        List<MenuItem> menuItems = new ArrayList<>();
        try {
            menuItems = jdbcTemplate.query("select id, item_name,item_price,is_active from menu_item where item_name like ?",new Object[]{"%"+itemName+"%"},
                    new int[]{1},
                    new MenuItemMapper());
        } catch (Exception e) {

        }
        return convertMenuItemEntToDto(menuItems);
    }


    public List<MenuItemDto> convertMenuItemEntToDto(List<MenuItem> menuItems) {
        List<MenuItemDto> menuItemDtos = new ArrayList<>();
        for(MenuItem item : menuItems) {
            MenuItemDto itemDto = MenuItemDto.builder().itemName(item.getItemName()).itemPrice(item.getItemPrice())
                    .id(item.getId()).isActive(item.getIsActive()).build();
            menuItemDtos.add(itemDto);
        }
        return menuItemDtos;
    }
}
