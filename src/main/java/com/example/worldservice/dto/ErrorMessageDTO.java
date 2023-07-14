package com.example.worldservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessageDTO {
    private String message;
    private String code;
    private String path;
}
