package com.example.rk.hotelmgmt.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="staff")
@Getter
@Setter
@Builder
@NamedNativeQuery(
        name="Staff.findPerfStaff",
        query = "select st.*  from staff st\n" +
                "inner join  (select staff_id,count(*) ordercount from order_header ordi\n" +
                "where ordi.completed_date is not null\n" +
                "group by staff_id) ord\n" +
                "on st.id = ord.staff_id\n" +
                "where ord.ordercount >= :numorder",
        resultClass = Staff.class
)
public class Staff {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
}
