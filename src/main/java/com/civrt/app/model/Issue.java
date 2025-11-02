
package com.civrt.app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Document(collection = "issue")
public class Issue {
    @Id
    private String id;

    private String title;
    private String category; // Road, Water, Waste, Streetlight, Drainage, Other
    private String description;

    @Builder.Default
    private Media media = new Media();

    @Builder.Default
    private Location location = new Location();

    @Builder.Default
    private String status = "New"; // New, In-Review, In-Progress, Resolved, Rejected

    @Builder.Default
    private String priority = "Medium"; // Low, Medium, High

    private String createdBy;
    private String assignedTo;

    @Builder.Default
    private List<History> history = new ArrayList<>();

    private Instant createdAt;
    private Instant updatedAt;

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class Media {
        private List<String> images = new ArrayList<>();
        private List<String> videos = new ArrayList<>();
    }

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class Location {
        private Double lat;
        private Double lng;
        private String address;
        private String ward;
    }

    @Data @NoArgsConstructor @AllArgsConstructor @Builder
    public static class History {
        private Instant at;
        private String by;
        private String action;   // created | status | assign | note
        private String note;
        private String toStatus;
    }
}
