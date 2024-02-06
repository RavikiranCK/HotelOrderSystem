package com.example.rk.hotelmgmt.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_detail")
@Getter
@Setter
@Builder
public class OrderDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private OrderHeader orderId;

    @ManyToOne
    @JoinColumn(name="item_id")
    private MenuItem itemId;

    private Integer qty;
    private String status;
    private Date createdDate;
    private String comments;

}
