package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaConsumer {

  private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

  @KafkaListener(topics = "patient", groupId = "analytics-service")
  public void consumeEvent(byte[] event) {
    try {
      PatientEvent patientEvent = PatientEvent.parseFrom(event);
      // ... perform any business logic to analytics here

      log.info(
          "Received patient event: [patientId = {}, firstname = {}, lastname = {}, birthDate = {}]",
          patientEvent.getPatientId(),
          patientEvent.getFirstname(),
          patientEvent.getLastname(),
          patientEvent.getBirthDate());
    } catch (InvalidProtocolBufferException e) {
      log.error("Error deserializing event: {}", e.getMessage());
    }
  }
}
