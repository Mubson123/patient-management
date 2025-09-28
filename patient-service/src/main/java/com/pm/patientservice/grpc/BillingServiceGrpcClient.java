package com.pm.patientservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import billing.BillingServiceGrpc.BillingServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BillingServiceGrpcClient {
    private final BillingServiceBlockingStub blockingStub;


    public BillingServiceGrpcClient(
            @Value("${billing.service.address:localhost}") String serverAddress,
            @Value("${billing.service.port:9001}") int serverPort) {

        log.info("Connceting to Billing Service GRPC at {}:{}", serverAddress, serverPort);
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(serverAddress, serverPort)
                .usePlaintext()
                .build();

        blockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }

    public void createBillingAccount(String patientId, String firstname, String lastname, String birthDate) {
        BillingRequest request = BillingRequest.newBuilder()
                .setPatientId(patientId)
                .setFirstname(firstname)
                .setLastname(lastname)
                .setBirthDate(birthDate)
                .build();

        BillingResponse response = blockingStub.createBillingAccount(request);
        log.info("Received response from Billing Service via GRPC: {}", response.toString());
    }
}
