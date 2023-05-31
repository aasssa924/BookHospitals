package com.example.bookhospitalappointments.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
public class AppointmentDTO {

    @FutureOrPresent
    @Column(columnDefinition = "date not null")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date bookingDate;
    private int patient_id;
    private String status;
}
