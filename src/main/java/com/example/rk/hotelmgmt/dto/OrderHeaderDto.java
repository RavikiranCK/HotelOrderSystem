package com.example.rk.hotelmgmt.dto;

import com.example.rk.hotelmgmt.entity.OrderDetail;
import com.example.rk.hotelmgmt.entity.Staff;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class OrderHeaderDto {
    private Integer id;

    private String name;
    private Date createdDate;
    private Date completedDate;

    private Staff staffId;

    private List<OrderDetailDto> orderDetailDtoList;
}
