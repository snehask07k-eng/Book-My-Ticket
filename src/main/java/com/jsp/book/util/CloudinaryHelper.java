package com.jsp.book.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CloudinaryHelper {

    private static final String MOVIE_FOLDER = "BMT-Movies";
    private static final String THEATER_FOLDER = "BMT-Theater";
    private static final String QR_FOLDER = "BMT-Theater-QR";

    private static final String FALLBACK_IMAGE = "https://placehold.co/600x400/EEE/31343C";

    // Base directory where files will be stored. Can be overridden via application
    // property
    // "local.storage.base-path". If not supplied, it defaults to "uploads" in the
    // project root.
    private final Path baseDir;

    /**
     * Constructs the helper.
     *
     * @param storageBasePath optional base directory for local storage. If empty,
     *                        defaults to "uploads".
     */
    public CloudinaryHelper(@Value("${local.storage.base-path:uploads}") String storageBasePath) {
        // Resolve against the current working directory (project root).
        this.baseDir = Paths.get(System.getProperty("user.dir"), storageBasePath).toAbsolutePath();
        try {
            Files.createDirectories(this.baseDir);
        } catch (IOException e) {
            // If we cannot create the directory, the helper will fall back to placeholder
            // images.
        }
    }

    public String generateImageLink(MultipartFile file) {
        return upload(file, MOVIE_FOLDER);
    }

    public String getTheaterImageLink(MultipartFile file) {
        return upload(file, THEATER_FOLDER);
    }

    public String saveTicketQr(byte[] qr) {
        return upload(qr, QR_FOLDER);
    }

    /* ---------- Private helpers ---------- */

    private String upload(MultipartFile file, String folder) {
        try {
            return upload(file.getBytes(), folder, file.getOriginalFilename());
        } catch (IOException e) {
            return FALLBACK_IMAGE;
        }
    }

    private String upload(byte[] data, String folder) {
        // When the original filename is unknown, generate a random one with .bin
        // extension.
        return upload(data, folder, UUID.randomUUID().toString() + ".bin");
    }

    private String upload(byte[] data, String folder, String originalFilename) {
        try {
            Path targetDir = baseDir.resolve(folder);
            Files.createDirectories(targetDir);
            // Generate a unique filename to avoid collisions.
            String uniqueName = UUID.randomUUID().toString() + "_"
                    + (originalFilename != null ? originalFilename : "file");
            Path targetFile = targetDir.resolve(uniqueName);
            Files.write(targetFile, data);
            // Return a relative URL that can be served as a static resource.
            // Example: "/uploads/BMT-Movies/uuid_original.jpg"
            Path relativePath = baseDir.getFileName().resolve(folder).resolve(uniqueName);
            return "/" + relativePath.toString().replace('\\', '/');
        } catch (IOException e) {
            return FALLBACK_IMAGE;
        }
    }
}
