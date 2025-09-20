package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Gender;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patientMapper.toDTOList(patients);
    }

    @Override
    public PatientResponseDTO getPatientById(UUID patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));
        return patientMapper.toDTO(patient);
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = patientMapper.toEntity(patientRequestDTO);
        //Set Registration Date only the first time
        patient.setRegistrationDate(LocalDateTime.now());
        patientRepository.save(patient);
        return patientMapper.toDTO(patient);
    }

    @Override
    public PatientResponseDTO updatePatient(UUID patientId, PatientRequestDTO patientRequestDTO) {
        Patient patientExists = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));
        Patient patientUpdated = patientMapper.toEntity(patientRequestDTO);
        patientUpdated.setId(patientId);
        patientUpdated.setRegistrationDate(patientExists.getRegistrationDate());
        Patient patientSaved = patientRepository.save(patientUpdated);
        return patientMapper.toDTO(patientSaved);
    }

    @Override
    public void deletePatientById(UUID patientId) {
        Patient patientExists = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));
        patientRepository.delete(patientExists);
    }
}
