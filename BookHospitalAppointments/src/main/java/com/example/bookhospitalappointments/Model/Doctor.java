package com.example.bookhospitalappointments.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name must be not empty")
    @Column(columnDefinition = "varchar(100) unique")
    private String name;

    @NotEmpty(message = "clinic must be not empty")
    @Column(columnDefinition = "varchar(50)")
    private String clinic;

    @NotEmpty(message = "rank must be not empty")
    @Column(columnDefinition = "varchar(20)")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "hospitals_id",referencedColumnName = "id")
    @JsonIgnore
    private Hospitals hospitals;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "doctor")
    private Set<Appointment> appointment;

    public Doctor (String name,String clinic,String rank,Hospitals H1){
        this.name=name;
        this.clinic=clinic;
        this.rank=rank;
        this.hospitals=H1;
    }

}