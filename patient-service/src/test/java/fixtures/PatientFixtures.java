package fixtures;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PatientFixtures {

    public static Patient john = Patient.builder()
            .id(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"))
            .registrationDate(LocalDateTime.now())
            .lastUpdateDate(LocalDateTime.now())
            .gender(Gender.MALE)
            .firstname("John")
            .lastname("Doe")
            .birthDate(LocalDate.parse("1985-06-15"))
            .phoneNumbers(List.of(new PhoneNumber("+49 156 93695645", PhoneTyp.MOBILE)))
            .email("john.doe@example.com")
            .address(Address.builder()
                    .street("123 Main St")
                    .zipCode("90402")
                    .city("Nürnberg")
                    .build())
            .build();

    public static PatientRequestDTO johnRequest = PatientRequestDTO.builder()
            .gender("MALE")
            .firstname("John")
            .lastname("Doe")
            .birthDate("1985-06-15")
            .phoneNumbers(List.of(new PhoneNumber("+49 156 93695645", PhoneTyp.MOBILE)))
            .email("john.doe@example.com")
            .street("123 Main St")
            .zipCode("90402")
            .city("Nürnberg")
            .build();

    public static PatientResponseDTO johnResponse = PatientResponseDTO.builder()
            .id("123e4567-e89b-12d3-a456-426614174000")
            .registrationDate(LocalDateTime.now())
            .lastUpdateDate(LocalDateTime.now())
            .gender("MALE")
            .firstname("John")
            .lastname("Doe")
            .birthDate("1985-06-15")
            .phoneNumbers(List.of(new PhoneNumber("+49 156 93695645", PhoneTyp.MOBILE)))
            .email("john.doe@example.com")
            .street("123 Main St")
            .zipCode("90402")
            .city("Nürnberg")
            .build();

    public static Patient sarah = Patient.builder()
            .id(UUID.fromString("223e4567-e89b-12d3-a456-426614174006"))
            .registrationDate(LocalDateTime.now())
            .lastUpdateDate(LocalDateTime.now())
            .gender(Gender.FEMALE)
            .firstname("Sarah")
            .lastname("Taylor")
            .birthDate(LocalDate.parse("1992-04-18"))
            .phoneNumbers(List.of(new PhoneNumber("+49 911 4786835", PhoneTyp.PRIVATE)))
            .email("sarah.taylor@example.com")
            .address(Address.builder()
                    .street("123 Birch St")
                    .zipCode("90408")
                    .city("Nürnberg")
                    .build())
            .build();

    public static PatientRequestDTO sarahRequest = PatientRequestDTO.builder()
            .gender("FEMALE")
            .firstname("Sarah")
            .lastname("Taylor")
            .birthDate("1992-04-18")
            .phoneNumbers(List.of(new PhoneNumber("+49 911 4786835", PhoneTyp.PRIVATE)))
            .email("sarah.taylor@example.com")
            .street("123 Birch St")
            .zipCode("90408")
            .city("Nürnberg")
            .build();

    public static PatientResponseDTO sarahResponse = PatientResponseDTO.builder()
            .id("223e4567-e89b-12d3-a456-426614174006")
            .registrationDate(LocalDateTime.now())
            .lastUpdateDate(LocalDateTime.now())
            .gender("FEMALE")
            .firstname("Sarah")
            .lastname("Taylor")
            .birthDate("1992-04-18")
            .phoneNumbers(List.of(new PhoneNumber("+49 911 4786835", PhoneTyp.PRIVATE)))
            .email("sarah.taylor@example.com")
            .street("123 Birch St")
            .zipCode("90408")
            .city("Nürnberg")
            .build();

    public static List<Patient> patientList = List.of(sarah, john);
    public static List<PatientResponseDTO> patientResponseDTOS = List.of(sarahResponse, johnResponse);
}
