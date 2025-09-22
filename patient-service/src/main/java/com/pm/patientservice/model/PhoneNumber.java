package com.pm.patientservice.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
    private String number;
    @Enumerated(EnumType.STRING)
    private PhoneTyp type;
}
