
package com.civrt.app.service;

import com.civrt.app.dto.CreateIssueRequest;
import com.civrt.app.dto.UpdateStatusRequest;
import com.civrt.app.model.Issue;
import com.civrt.app.repo.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final IssueRepository repo;

    public Issue create(CreateIssueRequest r) {
        Issue issue = Issue.builder()
                .title(r.getTitle())
                .category(r.getCategory() != null ? r.getCategory() : "Other")
                .description(r.getDescription())
                .media(new Issue.Media(
                        r.getImages() != null ? r.getImages() : List.of(),
                        r.getVideos() != null ? r.getVideos() : List.of()))
                .location(new Issue.Location(r.getLat(), r.getLng(), r.getAddress(), r.getWard()))
                .priority(r.getPriority() != null ? r.getPriority() : "Medium")
                .status("New")
                .createdBy(r.getCreatedBy() != null ? r.getCreatedBy() : "web-user")
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
        issue.getHistory().add(Issue.History.builder()
                .at(Instant.now()).by(issue.getCreatedBy()).action("created").note("").toStatus("New").build());
        return repo.save(issue);
    }

    public List<Issue> list(String status, String category, String q) {
        if (status != null && !status.isBlank()) return repo.findTop200ByStatusOrderByCreatedAtDesc(status);
        if (category != null && !category.isBlank()) return repo.findTop200ByCategoryOrderByCreatedAtDesc(category);
        return repo.findAll().stream()
                .sorted((a,b)->b.getCreatedAt().compareTo(a.getCreatedAt()))
                .limit(200).toList();
    }

    public Issue get(String id) { return repo.findById(id).orElse(null); }

    public Issue updateStatus(String id, UpdateStatusRequest r) {
        Issue issue = get(id);
        if (issue == null) return null;
        if (r.getStatus() != null) issue.setStatus(r.getStatus());
        issue.getHistory().add(Issue.History.builder()
                .at(Instant.now()).by(r.getBy()!=null? r.getBy():"admin")
                .action("status").note(r.getNote()).toStatus(issue.getStatus()).build());
        issue.setUpdatedAt(Instant.now());
        return repo.save(issue);
    }

    public Issue assign(String id, String assignedTo, String by, String note) {
        Issue issue = get(id);
        if (issue == null) return null;
        issue.setAssignedTo(assignedTo);
        issue.getHistory().add(Issue.History.builder()
                .at(Instant.now()).by(by!=null?by:"admin").action("assign").note(note).build());
        issue.setUpdatedAt(Instant.now());
        return repo.save(issue);
    }
}
