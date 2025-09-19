package com.pm.patientservice.mapper;

import com.pm.patientservice.model.Patient;
import com.pm.patientservice.dto.PatientResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientMapper {

    public PatientResponseDTO toDTO(Patient patient) {
        return PatientResponseDTO.builder()
                .id(patient.getId().toString())
                .registrationDate(patient.getRegistrationDate())
                .lastUpdateDate(patient.getLastUpdateDate())
                .gender(patient.getGender().name())
                .firstname(patient.getFirstname())
                .lastname(patient.getLastname())
                .birthDate(patient.getBirthDate().toString())
                .phone(patient.getPhone())
                .email(patient.getEmail())
                .street(patient.getAddress().getStreet())
                .zipCode(patient.getAddress().getZipCode())
                .city(patient.getAddress().getCity())
                .build();
    }

    public List<PatientResponseDTO> toDTOList(List<Patient> patients) {
        return patients.stream().map(this::toDTO).toList();
    }
}
