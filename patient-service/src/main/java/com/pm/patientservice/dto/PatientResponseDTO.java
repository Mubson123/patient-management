package com.pm.patientservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDTO {
    String id;
    LocalDateTime registrationDate;
    LocalDateTime lastUpdateDate;
    String gender;
    String firstname;
    String lastname;
    String birthDate;
    String phone;
    String email;
    String street;
    String zipCode;
    String city;
}
