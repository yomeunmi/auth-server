package com.auth.server.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {

    private String responseCode;
    private String responseMessage;
    private int errorCode;

    @Builder.Default
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("timestamp")
    private LocalDateTime timestamp = LocalDateTime.now();
}
