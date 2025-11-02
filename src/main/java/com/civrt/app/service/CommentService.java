
package com.civrt.app.service;

import com.civrt.app.dto.CreateCommentRequest;
import com.civrt.app.model.Comment;
import com.civrt.app.repo.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository repo;

    public Comment create(String issueId, CreateCommentRequest r) {
        Comment c = Comment.builder()
                .issueId(issueId)
                .by(r.getBy()!=null? r.getBy():"web-user")
                .text(r.getText())
                .media(r.getMedia()!=null? r.getMedia(): List.of())
                .createdAt(Instant.now())
                .build();
        return repo.save(c);
    }

    public List<Comment> list(String issueId) {
        return repo.findByIssueIdOrderByCreatedAtAsc(issueId);
    }
}
