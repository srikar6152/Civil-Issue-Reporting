package com.civrt.app.service;

import com.civrt.app.model.Image;
import com.civrt.app.service.MediaService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryMediaService implements MediaService {

    private final Cloudinary cloudinary;

    @Value("${cloudinary.folder:cirp/uploads}")
    private String defaultFolder;

    @Override
    public Image uploadImage(MultipartFile file, String folder) throws Exception {
        String targetFolder = (folder == null || folder.isBlank()) ? defaultFolder : folder;

        Map result = cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap(
                        "folder", targetFolder,
                        "resource_type", "auto"
                )
        );

        Image image = new Image();
        image.setUrl((String) result.get("secure_url"));
        image.setPublicId((String) result.get("public_id"));
        image.setFormat((String) result.get("format"));
        image.setSize(result.get("bytes") != null ? ((Number) result.get("bytes")).longValue() : 0L);

        return image;
    }
}
