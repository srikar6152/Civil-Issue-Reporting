package com.civrt.app.repo;

import com.civrt.app.model.Issue;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Simple in-memory repository to satisfy compile/runtime while you don't have JPA enabled.
 * Replace this with a JPA repository implementation when you add persistence.
 */
@Repository
public class InMemoryIssueRepository implements IssueRepository {
    private final Map<String, Issue> store = new ConcurrentHashMap<>();

    @Override
    public Issue save(Issue issue) {
        if (issue.getId() == null || issue.getId().isBlank()) {
            issue.setId(UUID.randomUUID().toString());
        }
        store.put(issue.getId(), issue);
        return issue;
    }

    @Override
    public List<Issue> findTop200ByStatusOrderByCreatedAtDesc(String status) {
        return store.values().stream()
                .filter(i -> status.equals(i.getStatus()))
                .sorted(Comparator.comparing(Issue::getCreatedAt).reversed())
                .limit(200)
                .collect(Collectors.toList());
    }

    @Override
    public List<Issue> findTop200ByCategoryOrderByCreatedAtDesc(String category) {
        return store.values().stream()
                .filter(i -> category.equals(i.getCategory()))
                .sorted(Comparator.comparing(Issue::getCreatedAt).reversed())
                .limit(200)
                .collect(Collectors.toList());
    }

    @Override
    public List<Issue> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Issue> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }
}
