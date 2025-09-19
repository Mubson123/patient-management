package com.pm.patientservice.dto;

import com.pm.patientservice.model.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {
    @NotBlank(message = "You should provide gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Size(max = 100, message = "Firstname is required")
    private String firstname;
    @Size(max = 100, message = "Lastname is required")
    private String lastname;
    @NotBlank(message = "Birthdate is required")
    private LocalDate birthDate;
    private String phone;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "Zipcode is required")
    private String zipCode;
    @NotBlank(message = "City is required")
    private String city;
}
