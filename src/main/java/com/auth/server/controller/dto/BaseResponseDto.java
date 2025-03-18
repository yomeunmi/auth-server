package com.auth.server.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDto {

    private String responseCode = "00000";
    private String responseMessage = "OK";

    @JsonProperty("timestamp")
    private LocalDateTime timestamp = LocalDateTime.now();
}
