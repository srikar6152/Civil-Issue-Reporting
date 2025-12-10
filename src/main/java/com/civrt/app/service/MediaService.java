package com.civrt.app.service;

import com.civrt.app.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface MediaService {
    Image uploadImage(MultipartFile file, String folder) throws Exception;
}
