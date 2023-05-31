package com.example.bookhospitalappointments.Service;

import com.example.bookhospitalappointments.ApiException.ApiException;
import com.example.bookhospitalappointments.DTO.AppointmentDTO;
import com.example.bookhospitalappointments.DTO.DoctorDTO;
import com.example.bookhospitalappointments.Model.Appointment;
import com.example.bookhospitalappointments.Model.Doctor;
import com.example.bookhospitalappointments.Model.Hospitals;
import com.example.bookhospitalappointments.Model.Patient;
import com.example.bookhospitalappointments.Repository.DoctorRepository;
import com.example.bookhospitalappointments.Repository.HospitalsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final HospitalsRepository hospitalsRepository;

    public List<Doctor> doctors(){
        return doctorRepository.findAll();
    }

    public void addDoctor(DoctorDTO dto, Errors errors){
        if (errors.hasErrors()){
            throw new ApiException(errors.getFieldError().getDefaultMessage());
        }
        Hospitals hospitals = hospitalsRepository.findById(dto.getHospitals_id())
                .orElseThrow(()-> new ApiException("Hospitals id not found"));

        Doctor doctor = new Doctor(dto.getName(), dto.getClinic(), dto.getRank(),hospitals);
        doctorRepository.save(doctor);
    }

    public void updateDoctor(Integer id,DoctorDTO dto, Errors errors){
        if (errors.hasErrors()){
            throw new ApiException(errors.getFieldError().getDefaultMessage());
        }
        Hospitals hospitals = hospitalsRepository.findById(dto.getHospitals_id())
                .orElseThrow(()-> new ApiException("Hospitals id not found"));

        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ApiException("doctor id not found"));
        doctor.setName(dto.getName());
        doctor.setClinic(dto.getClinic());
        doctor.setRank(dto.getRank());
        doctor.setHospitals(hospitals);
        doctorRepository.save(doctor);
    }

    public void delete(int id){
        Doctor findDoctor = doctorRepository.findById(id).orElseThrow(()-> new ApiException("id not found"));
        doctorRepository.delete(findDoctor);
    }



}
