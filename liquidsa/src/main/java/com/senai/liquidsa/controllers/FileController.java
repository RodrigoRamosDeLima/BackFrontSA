package com.senai.liquidsa.controllers;

import com.senai.liquidsa.entities.FileEntity;
import com.senai.liquidsa.entities.UsuarioEntity;
import com.senai.liquidsa.services.FileService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<Long> saveFile(
            @RequestParam("file") MultipartFile file,
            @RequestAttribute(value = "loggedUser", required = false) UsuarioEntity loggedUser
    ) {
        try {
            Long fileId = fileService.saveFile(file, loggedUser.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(fileId);
        } catch (Exception ignored) {
            System.out.println();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable("id") Long id) {
        FileEntity fileEntity = fileService.getFileById(id);
        File file = new File(fileEntity.getPath());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            FileUtils.copyFile(file, byteArrayOutputStream);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.valueOf(fileEntity.getType()))
                    .body(byteArrayOutputStream.toByteArray());
        } catch (IOException ignored) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
