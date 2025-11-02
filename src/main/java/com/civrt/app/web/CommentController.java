
package com.civrt.app.web;

import com.civrt.app.dto.CreateCommentRequest;
import com.civrt.app.model.Comment;
import com.civrt.app.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService svc;
    private final RealtimeGateway rt;

    @PostMapping("/{issueId}")
    public ResponseEntity<?> create(@PathVariable String issueId, @RequestBody CreateCommentRequest req) {
        if (req.getText() == null || req.getText().isBlank()) {
            return ResponseEntity.badRequest().body("text is required");
        }
        Comment c = svc.create(issueId, req);
        rt.commentCreated(issueId, c);
        return ResponseEntity.status(201).body(c);
    }

    @GetMapping("/{issueId}")
    public List<Comment> list(@PathVariable String issueId) {
        return svc.list(issueId);
    }
}
