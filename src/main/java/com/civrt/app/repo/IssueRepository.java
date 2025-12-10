package com.civrt.app.repo;

import com.civrt.app.model.Issue;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface used by your IssueService.
 * We also provide a simple in-memory implementation below.
 */
public interface IssueRepository {
    Issue save(Issue issue);
    List<Issue> findTop200ByStatusOrderByCreatedAtDesc(String status);
    List<Issue> findTop200ByCategoryOrderByCreatedAtDesc(String category);
    List<Issue> findAll();
    Optional<Issue> findById(String id);
}
