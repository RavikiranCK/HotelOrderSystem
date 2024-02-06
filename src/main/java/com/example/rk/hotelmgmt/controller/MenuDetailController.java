package com.example.rk.hotelmgmt.controller;

import com.example.rk.hotelmgmt.dto.MenuItemDto;
import com.example.rk.hotelmgmt.dto.ResponseEntity;
import com.example.rk.hotelmgmt.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuDetailController {

    @Autowired
    MenuService menuSvc;

    @PostMapping("/createmenuitem")
    public ResponseEntity<MenuItemDto> createMenuItem(@RequestBody MenuItemDto item) {
        try {
            ResponseEntity<MenuItemDto>  response =new ResponseEntity<>();
            MenuItemDto menuItem= menuSvc.createMenuItem(item);
            response.setData(menuItem);
            response.setStatus(HttpStatus.OK);
            return response;

        }catch (Exception e) {
            ResponseEntity response = new ResponseEntity<>();
            response.setMsg(e.getMessage());
            response.setStatus(HttpStatus.BAD_REQUEST);
            return response;
        }
    }
    @GetMapping("/menuitembyjpa")
    public ResponseEntity<List<MenuItemDto>> getMatchingByJpa(@RequestParam String itemname) {
        ResponseEntity<List<MenuItemDto>>  response =new ResponseEntity<>();
        response.setData(menuSvc.getmatchingByJPA(itemname));
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @GetMapping("/menuitembyquery")
    public ResponseEntity<List<MenuItemDto>> getMatchingQuery(@RequestParam String itemname) {
        ResponseEntity<List<MenuItemDto>>  response =new ResponseEntity<>();
        response.setData(menuSvc.getMatchingItemByQuery(itemname));
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @GetMapping("/menuitemusingjdbc")
    public ResponseEntity<List<MenuItemDto>> getMatchingByJdbc(@RequestParam String itemname) {
        ResponseEntity<List<MenuItemDto>>  response =new ResponseEntity<>();
        response.setData(menuSvc.getMatchingItemByJdbc(itemname));
        response.setStatus(HttpStatus.OK);
        return response;
    }
}
