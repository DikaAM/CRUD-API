package com.portofolio.tryapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StudentRequest {

    private String firstName;
    private String lastName;
    private String email;

}
