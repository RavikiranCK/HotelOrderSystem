package com.example.rk.hotelmgmt.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="menu_item")
@Getter
@Setter
@Builder
public class MenuItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String itemName;
    Integer itemPrice;
    String isActive;

}
