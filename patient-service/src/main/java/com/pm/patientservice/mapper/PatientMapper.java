package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.model.Address;
import com.pm.patientservice.model.Gender;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.dto.PatientResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    public Patient toEntity(PatientRequestDTO patientRequestDTO) {
        Address address = new Address();
        Patient patient = new Patient();

        address.setStreet(patientRequestDTO.getStreet());
        address.setZipCode(patientRequestDTO.getZipCode());
        address.setCity(patientRequestDTO.getCity());

        patient.setLastUpdateDate(LocalDateTime.now());
        patient.setGender(Gender.valueOf(patientRequestDTO.getGender()));
        patient.setFirstname(patientRequestDTO.getFirstname());
        patient.setLastname(patientRequestDTO.getLastname());
        patient.setBirthDate(LocalDate.parse(patientRequestDTO.getBirthDate()));
        patient.setPhone(patientRequestDTO.getPhone());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(address);
        return patient;
    }
}
