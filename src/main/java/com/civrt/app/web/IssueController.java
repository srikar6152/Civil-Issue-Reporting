
package com.civrt.app.web;

import com.civrt.app.dto.CreateIssueRequest;
import com.civrt.app.dto.UpdateStatusRequest;
import com.civrt.app.model.Issue;
import com.civrt.app.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService svc;
    private final RealtimeGateway rt;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateIssueRequest req) {
        if (req.getTitle() == null || req.getTitle().isBlank()) {
            return ResponseEntity.badRequest().body("title is required");
        }
        Issue saved = svc.create(req);
        rt.issueCreated(saved);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<Issue> list(@RequestParam(required = false) String status,
                            @RequestParam(required = false) String category,
                            @RequestParam(required = false) String q) {
        return svc.list(status, category, q);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        Issue i = svc.get(id);
        return i == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(i);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> status(@PathVariable String id, @RequestBody UpdateStatusRequest req) {
        Issue updated = svc.updateStatus(id, req);
        if (updated == null) return ResponseEntity.notFound().build();
        rt.issueUpdated(updated);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}/assign")
    public ResponseEntity<?> assign(@PathVariable String id,
                                    @RequestParam String assignedTo,
                                    @RequestParam(required=false) String by,
                                    @RequestParam(required=false) String note) {
        Issue updated = svc.assign(id, assignedTo, by, note);
        if (updated == null) return ResponseEntity.notFound().build();
        rt.issueUpdated(updated);
        return ResponseEntity.ok(updated);
    }
}
