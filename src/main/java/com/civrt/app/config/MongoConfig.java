
package com.civrt.app.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

@Configuration
@RequiredArgsConstructor
public class MongoConfig {

    private final MongoTemplate mongo;

    @PostConstruct
    void ensureIndexes() {
        mongo.indexOps("issue")
            .ensureIndex(new Index().on("status", org.springframework.data.domain.Sort.Direction.ASC)
                                    .on("createdAt", org.springframework.data.domain.Sort.Direction.DESC));
        mongo.indexOps("issue")
            .ensureIndex(new Index().on("assignedTo", org.springframework.data.domain.Sort.Direction.ASC)
                                    .on("updatedAt", org.springframework.data.domain.Sort.Direction.DESC));
        mongo.indexOps("comment")
            .ensureIndex(new Index().on("issueId", org.springframework.data.domain.Sort.Direction.ASC)
                                    .on("createdAt", org.springframework.data.domain.Sort.Direction.ASC));
    }
}
