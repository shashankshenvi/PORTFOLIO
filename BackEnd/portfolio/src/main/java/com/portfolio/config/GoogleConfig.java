package com.portfolio.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

@Configuration
public class GoogleConfig {

    @Value("${google.credentials.path}")
    private String credentialsPath;  // This allows dynamic path configuration via application.properties

    private static final String APPLICATION_NAME = "PortfolioApp";

    @Bean
    public Drive googleDrive() throws IOException {
        FileInputStream credentialsStream = new FileInputStream(credentialsPath);

        GoogleCredential credential = GoogleCredential.fromStream(credentialsStream)
                .createScoped(Collections.singleton(DriveScopes.DRIVE_FILE));

        HttpTransport httpTransport = credential.getTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        return new Drive.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
}