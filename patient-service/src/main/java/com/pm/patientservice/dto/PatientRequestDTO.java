package com.pm.patientservice.dto;

import com.pm.patientservice.model.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {
    @NotBlank(message = "You should provide gender")
    private String gender;
    @NotBlank(message = "Firstname is required")
    @Size(max = 100)
    private String firstname;
    @NotBlank(message = "Lastname is required")
    @Size(max = 100)
    private String lastname;
    @NotBlank(message = "Birthdate is required")
    private String birthDate;
    private List<PhoneNumber> phoneNumbers;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "Zipcode is required")
    private String zipCode;
    @NotBlank(message = "City is required")
    private String city;
}
