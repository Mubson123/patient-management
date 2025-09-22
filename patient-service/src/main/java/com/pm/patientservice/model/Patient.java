package com.pm.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime registrationDate;
    private LocalDateTime lastUpdateDate;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private LocalDate birthDate;
    @ElementCollection
    @CollectionTable(
            name = "patient_phone",
            joinColumns = @JoinColumn(name = "patient_id")
    )
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    @Email
    private String email;
    @Embedded
    private Address address;
}
