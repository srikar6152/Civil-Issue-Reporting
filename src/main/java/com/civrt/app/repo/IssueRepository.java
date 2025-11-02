
package com.civrt.app.repo;

import com.civrt.app.model.Issue;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface IssueRepository extends MongoRepository<Issue, String> {
    List<Issue> findTop200ByStatusOrderByCreatedAtDesc(String status);
    List<Issue> findTop200ByCategoryOrderByCreatedAtDesc(String category);
}
