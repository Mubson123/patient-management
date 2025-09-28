package service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

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
}
