
package com.civrt.app.web;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RealtimeGateway {
    private final SimpMessagingTemplate simp;

    public void issueCreated(Object payload) {
        simp.convertAndSend("/topic/issues.created", payload);
    }
    public void issueUpdated(Object payload) {
        simp.convertAndSend("/topic/issues.updated", payload);
    }
    public void commentCreated(String issueId, Object payload) {
        simp.convertAndSend("/topic/comments." + issueId, payload);
    }
}
