package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Patient REST Controller", description = "API for managing patients")
@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;


    @GetMapping
    @Operation(summary = "Endpoint to Get all patients", description = "Returns all patients")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{patientId}")
    @Operation(summary = "Endpoint to Get patient by id", description = "Returns patient details by ID")
    public ResponseEntity<PatientResponseDTO> getPatientById(
            @PathVariable UUID patientId) {
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

    @PostMapping
    @Operation(summary = "Endpoint to Create patient", description = "Creates a new patient")
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Valid @RequestBody PatientRequestDTO requestDTO) {
        PatientResponseDTO responseDTO = patientService.createPatient(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{patientId}")
    @Operation(summary = "Endpoint to Update patient", description = "Updates patient details")
    public ResponseEntity<PatientResponseDTO> updatePatient(
            @PathVariable UUID patientId, @Valid @RequestBody PatientRequestDTO requestDTO) {
        PatientResponseDTO responseDTO = patientService.updatePatient(patientId, requestDTO);
        return ResponseEntity.accepted().body(responseDTO);
    }

    @DeleteMapping(value = "/{patientId}")
    @Operation(summary = "Endpoint to Delete patient", description = "Deletes patient details")
    public ResponseEntity<Void> deletePatientById(@PathVariable UUID patientId) {
        patientService.deletePatientById(patientId);
        return ResponseEntity.noContent().build();
    }
}
