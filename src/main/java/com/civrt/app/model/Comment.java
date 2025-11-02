
package com.civrt.app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Document(collection = "comment")
public class Comment {
    @Id
    private String id;

    private String issueId;
    private String by;
    private String text;

    @Builder.Default
    private List<String> media = new ArrayList<>();

    private Instant createdAt;
}
