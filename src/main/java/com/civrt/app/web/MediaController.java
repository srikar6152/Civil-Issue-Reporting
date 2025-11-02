
package com.civrt.app.web;

import com.civrt.app.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file,
                                    @RequestParam(value = "folder", required = false) String folder) {
        try {
            Map result = mediaService.upload(file, folder);
            return ResponseEntity.ok(Map.of(
                "url", result.get("secure_url"),
                "public_id", result.get("public_id"),
                "resource_type", result.get("resource_type")
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                "error", "upload_failed",
                "detail", e.getMessage()
            ));
        }
    }
}
