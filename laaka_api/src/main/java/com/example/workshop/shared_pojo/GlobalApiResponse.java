package com.example.workshop.shared_pojo;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalApiResponse <T> {
    private String message;
    private T data;
    private Integer StatusCode;
}
