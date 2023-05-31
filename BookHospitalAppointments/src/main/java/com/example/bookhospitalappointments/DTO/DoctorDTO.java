package com.example.bookhospitalappointments.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorDTO {

    @NotEmpty(message = "name must be not empty")
    private String name;

    @NotEmpty(message = "clinic must be not empty")
    private String clinic;

    @NotEmpty(message = "rank must be not empty")
    private String rank;


    private Integer hospitals_id;


}