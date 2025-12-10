package com.civrt.app.controller;

import com.civrt.app.model.Issue;
import com.civrt.app.model.Image;
import com.civrt.app.service.IssueService;
import com.civrt.app.service.MediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final MediaService mediaService;
    private final IssueService issueService;

    public IssueController(MediaService mediaService, IssueService issueService) {
        this.mediaService = mediaService;
        this.issueService = issueService;
    }

    /**
     * POST /api/issues
     * Accepts multipart/form-data:
     * - title (String)
     * - category (String)
     * - description (String)
     * - locationText (String)
     * - lat (optional double)
     * - lng (optional double)
     * - images[] (optional file[])
     */
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createIssue(
        @RequestParam("title") String title,
        @RequestParam("category") String category,
        @RequestParam("description") String description,
        @RequestParam("locationText") String locationText,
        @RequestParam(value = "lat", required = false) Double lat,
        @RequestParam(value = "lng", required = false) Double lng,
        @RequestParam(value = "images", required = false) MultipartFile[] images
    ) {
        try {
            Issue issue = new Issue();
            issue.setTitle(title);
            issue.setCategory(category);
            issue.setDescription(description);
            issue.setLocationText(locationText);
            issue.setLat(lat);
            issue.setLng(lng);

            List<Image> imageList = new ArrayList<>();
            if (images != null && images.length > 0) {
                for (MultipartFile file : images) {
                    if (file != null && !file.isEmpty()) {
                        Image uploaded = mediaService.uploadImage(file, "janreport/issues");
                        imageList.add(uploaded);
                    }
                }
            }
            issue.setImages(imageList);

            Issue saved = issueService.saveIssue(issue);
            return ResponseEntity.status(201).body(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error saving issue: " + e.getMessage());
        }
    }

    // GET all issues (for dashboard)
    @GetMapping
    public ResponseEntity<?> getAllIssues() {
        return ResponseEntity.ok(issueService.getAllIssues());
    }
}
