package com.pm.patientservice.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    @NotNull
    private String street;
    @NotNull
    private String zipCode;
    @NotNull
    private String city;
}
