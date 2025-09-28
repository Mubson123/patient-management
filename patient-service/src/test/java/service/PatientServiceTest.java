package service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.PatientAlreadyExistsException;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.grpc.BillingServiceGrpcClient;
import com.pm.patientservice.kafka.KafkaProducer;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import com.pm.patientservice.service.PatientServiceImpl;
import fixtures.PatientFixtures;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private BillingServiceGrpcClient billingServiceGrpcClient;
    @Mock
    private KafkaProducer kafkaProducer;
    @Mock
    private PatientMapper patientMapper;
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientServiceImpl unitUnderTest;

    @Test
    void shouldReturnAllPatients() {
        List<Patient> patientList = PatientFixtures.patientList;
        List<PatientResponseDTO> expected = PatientFixtures.patientResponseDTOS;
        when(patientRepository.findAll()).thenReturn(patientList);
        when(patientMapper.toDTOList(patientList)).thenReturn(expected);

        List<PatientResponseDTO> actual = unitUnderTest.getAllPatients();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnPatientById() {
        Patient patient = PatientFixtures.sarah;
        PatientResponseDTO expected = PatientFixtures.sarahResponse;
        when(patientRepository.findById(patient.getId())).thenReturn(Optional.of(patient));
        when(patientMapper.toDTO(patient)).thenReturn(expected);

        PatientResponseDTO actual = unitUnderTest.getPatientById(patient.getId());
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenPatientNotFound() {
        when(patientRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(PatientNotFoundException.class, () -> unitUnderTest.getPatientById(any()));
    }

    @Test
    void shouldCreatePatient() {
        Patient patient = PatientFixtures.john;
        PatientRequestDTO patientRequestDTO = PatientFixtures.johnRequest;
        PatientResponseDTO expected = PatientFixtures.johnResponse;
        when(patientRepository.existsByEmail(patientRequestDTO.getEmail())).thenReturn(false);
        when(patientMapper.toEntity(patientRequestDTO)).thenReturn(patient);
        when(patientRepository.save(patient)).thenReturn(patient);
        doNothing().when(billingServiceGrpcClient).createBillingAccount(anyString(), anyString(), anyString(), anyString());
        doNothing().when(kafkaProducer).sendEvent(patient);
        when(patientMapper.toDTO(patient)).thenReturn(expected);

        PatientResponseDTO actual = unitUnderTest.createPatient(patientRequestDTO);
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenEmailAlreadyExists() {
        PatientRequestDTO patientRequestDTO = PatientFixtures.sarahRequest;
        when(patientRepository.existsByEmail(anyString())).thenReturn(true);
        assertThrows(PatientAlreadyExistsException.class, () -> unitUnderTest.createPatient(patientRequestDTO));
    }

    @Test
    void shouldUpdatePatient() {
        Patient patient = PatientFixtures.john;
        PatientRequestDTO patientRequestDTO = PatientFixtures.johnRequest;
        PatientResponseDTO expected = PatientFixtures.johnResponse;
        when(patientRepository.findById(patient.getId())).thenReturn(Optional.of(patient));
        when(patientMapper.toEntity(patientRequestDTO)).thenReturn(patient);
        when(patientRepository.save(patient)).thenReturn(patient);
        when(patientMapper.toDTO(patient)).thenReturn(expected);

        PatientResponseDTO actual = unitUnderTest.updatePatient(patient.getId(), patientRequestDTO);
        assertEquals(expected, actual);
    }

    @Test
    void shouldDeletePatient() {
        Patient patient = PatientFixtures.sarah;
        when(patientRepository.findById(patient.getId())).thenReturn(Optional.of(patient));
        doNothing().when(patientRepository).delete(patient);
        unitUnderTest.deletePatientById(patient.getId());
        verify(patientRepository).delete(patient);
    }
}
