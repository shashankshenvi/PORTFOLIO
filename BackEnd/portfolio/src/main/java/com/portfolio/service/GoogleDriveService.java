package com.portfolio.service;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.About;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;

@Service
public class GoogleDriveService {

    private static final Logger logger = LoggerFactory.getLogger(GoogleDriveService.class);

    private final Drive googleDrive;

    @Autowired
    public GoogleDriveService(Drive googleDrive) {
        this.googleDrive = googleDrive;
    }

    // Check if Google Drive is connected
    private boolean isDriveConnected() {
        try {
            About about = googleDrive.about().get().setFields("user").execute();
            String displayName = about.getUser().getDisplayName();
           System.out.println("Google Drive connected successfully. User: {}"+ displayName);
            return true;  // Connection successful
        } catch (Exception e) {
        	 System.out.println("Google Drive connection failed: {}"+ e.getMessage());
            return false;  // Connection failed
        }
    }

    public String uploadFile(MultipartFile file) {
        // Check Google Drive connection
        if (!isDriveConnected()) {
        	 System.err.println("Google Drive connection failed. File upload aborted.");
            throw new RuntimeException("Google Drive is not connected.");
        }

        try {
        	 System.out.println("Uploading file: {}"+ file.getOriginalFilename());

            // Create file metadata
            File fileMetadata = new File();
            fileMetadata.setName(file.getOriginalFilename());
            fileMetadata.setParents(Collections.singletonList("YOUR_GOOGLE_DRIVE_FOLDER_ID"));  // Replace with your folder ID

            // Set up the upload stream content
            var uploadStreamContent = new com.google.api.client.http.InputStreamContent(
                    file.getContentType(), file.getInputStream());

            // Upload the file
            System.out.println("Uploading file to Google Drive...");
            File uploadedFile = googleDrive.files().create(fileMetadata, uploadStreamContent)
                    .setFields("id")
                    .execute();

            // Get and log the uploaded file ID
            String fileId = uploadedFile.getId();
            System.out.println("File uploaded successfully. File ID: {}"+ fileId);

            return fileId;  // Return the uploaded file ID

        } catch (Exception e) {
        	 System.err.println("File upload failed: {}"+ e.getMessage());
            throw new RuntimeException("File upload to Google Drive failed.", e);
        }
    }
}