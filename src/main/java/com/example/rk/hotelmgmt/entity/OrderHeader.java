package com.example.rk.hotelmgmt.entity;



import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_header")
@Getter
@Setter
@Builder
public class OrderHeader {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Date createdDate;
    private Date completedDate;

    @ManyToOne
    @JoinColumn(name = "STAFF_ID")
    private Staff staffId;

    @OneToMany(mappedBy="orderId" )
    private List<OrderDetail> orderDetail;

}
