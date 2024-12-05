package com.senai.liquidsa.services;

import com.senai.liquidsa.entities.FileEntity;
import com.senai.liquidsa.repositories.FileRepository;
import net.sf.jmimemagic.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {

    private final FileRepository fileRepository;
    private final String homePath;

    public FileService(
            FileRepository fileRepository,
            @Value("${user.home}") String homePath
    ) {
        this.fileRepository = fileRepository;
        this.homePath = homePath;
    }

    public FileEntity getFileById(Long fileId) {
        return fileRepository.findById(fileId).orElse(null);
    }

    public Long saveFile(MultipartFile file, Long userId) {
        try {
            File newFile = new File(
                    "%s/files/%s/%s/%s"
                            .formatted(
                                    homePath,
                                    userId,
                                    System.currentTimeMillis(),
                                    file.getOriginalFilename()
                            )
            );
            FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
            FileEntity fileEntity = fileRepository.save(
                    FileEntity
                            .builder()
                            .name(file.getOriginalFilename())
                            .path(newFile.getPath())
                            .type(file.getContentType())
                            .build()
            );
//            String type = Files.probeContentType(newFile.toPath());
//            if (type == null) type = this.mimoType(newFile);
            return fileEntity.getId();
        } catch (IOException ignored) {
        }

        return null;
    }

    private String mimoType(File file) throws MagicMatchNotFoundException, MagicException, MagicParseException {
        MagicMatch match = Magic.getMagicMatch(file, false, false);
        return switch (match.getMimeType()) {
            case "image/gif" -> ".gif";
            case "image/png" -> ".png";
            case "image/tiff" -> ".tif";
            case "image/jpeg" -> ".jpg";
            case "text/plain" -> ".txt";
            case "application/vnd.openxmlformats-officedocument.wordprocessingml.document" -> ".docx";
            case "application/msword" -> ".doc";
            case "text/rtf" -> ".rtf";
            case "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" -> ".xlsx";
            case "application/vnd.openxmlformats-officedocument.presentationml.presentation" -> ".pptx";
            case "application/pdf" -> ".pdf";
            case "application/postscript" -> ".ps";
            case "application/java" -> ".class";
            case "audio/mp3" -> ".mp3";
            case "application/x-wav" -> ".wav";
            case "application/vnd.oasis.opendocument.text" -> ".odt";
            case "application/zip" -> ".zip";
            default -> "";
        };
    }

}