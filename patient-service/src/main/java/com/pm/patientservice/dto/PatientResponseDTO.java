package com.pm.patientservice.dto;

import com.pm.patientservice.model.PhoneNumber;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
    List<PhoneNumber> phoneNumbers;
    String email;
    String street;
    String zipCode;
    String city;
}
