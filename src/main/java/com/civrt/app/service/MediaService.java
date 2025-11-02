
package com.civrt.app.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MediaService {
    private final Cloudinary cloudinary;

    @Value("${cloudinary.folder:cirp/uploads}")
    private String defaultFolder;

    public Map upload(MultipartFile file, String folder) throws Exception {
        String target = (folder == null || folder.isBlank()) ? defaultFolder : folder;
        return cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
            "folder", target,
            "resource_type", "auto"
        ));
    }
}
