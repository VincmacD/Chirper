package com.cst8277.usermanagementservice.handler;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class CustomErrorResponse {
    private String code;
    private Object data;
    private String message;
}





