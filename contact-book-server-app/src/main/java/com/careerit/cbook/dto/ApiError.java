package com.careerit.cbook.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {

    private String message;
    private String path;
    private int status;
    private LocalDateTime timestamp;
}
