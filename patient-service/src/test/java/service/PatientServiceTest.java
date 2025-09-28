package service;

import com.pm.patientservice.dto.PatientResponseDTO;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

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



}
