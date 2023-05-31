package com.example.bookhospitalappointments.Controller;

import com.example.bookhospitalappointments.DTO.DoctorDTO;
import com.example.bookhospitalappointments.Model.Doctor;
import com.example.bookhospitalappointments.Service.DoctorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/doctor")
@AllArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(doctorService.doctors());
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody DoctorDTO doctorDTO, Errors errors){
        doctorService.addDoctor(doctorDTO, errors);
        return ResponseEntity.status(200).body("Success");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody DoctorDTO doctorDTO, Errors errors){
        doctorService.updateDoctor(id, doctorDTO, errors);
        return ResponseEntity.status(200).body("Success");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        doctorService.delete(id);
        return ResponseEntity.status(200).body("Success");
    }

}