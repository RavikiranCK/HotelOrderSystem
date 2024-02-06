package com.example.rk.hotelmgmt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StaffDto {
    private Integer id;

    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
}
