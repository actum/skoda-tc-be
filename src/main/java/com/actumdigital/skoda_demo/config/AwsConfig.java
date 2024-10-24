package com.actumdigital.skoda_demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.frauddetector.FraudDetectorClient;

@Configuration
@Profile("cloud")
public class AwsConfig {

    @Value("${aws.access-key-id}")
    private String accessKeyId;

    @Value("${aws.secret-access-key}")
    private String secretAccessKey;

    @Value("${aws.region}")
    private String region;

    @Value("${aws.fraud-detector.detector-id}")
    private String detectorId;

    @Bean
    public FraudDetectorClient fraudDetectorClient() {
        return FraudDetectorClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
                .region(Region.of(region))
                .build();
    }

    @Bean
    public String getDetectorId() {
        return detectorId;
    }
}
