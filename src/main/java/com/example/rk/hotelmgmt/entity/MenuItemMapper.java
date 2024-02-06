package com.example.rk.hotelmgmt.entity;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuItemMapper implements RowMapper<MenuItem> {

    @Override
    public MenuItem mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        MenuItem temp = new MenuItem();
        temp.setId(resultSet.getInt(1));
        temp.setItemName(resultSet.getString(2));
        temp.setItemPrice(Integer.valueOf(resultSet.getInt(3)));
        temp.setIsActive(resultSet.getString(4));
        return temp;
    }

}
