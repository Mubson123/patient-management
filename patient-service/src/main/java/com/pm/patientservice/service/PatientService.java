package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    List<PatientResponseDTO> getAllPatients();
    PatientResponseDTO getPatientById(UUID patientId);
    PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);
    PatientResponseDTO updatePatient(UUID patientId, PatientRequestDTO patientRequestDTO);
    void deletePatientById(UUID patientId);
}
