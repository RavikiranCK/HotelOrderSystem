package com.example.rk.hotelmgmt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString(of = {"data"})
public class ResponseEntity<T> {

    private String msg;
    private HttpStatus status;
    private T data;

    public void ResponseEntity() {};
}
