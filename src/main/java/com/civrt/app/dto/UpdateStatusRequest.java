package com.civrt.app.dto;

/**
 * Simple DTO for updating status.
 */
public class UpdateStatusRequest {
    private String status;
    private String by;
    private String note;

    public UpdateStatusRequest() {}

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getBy() { return by; }
    public void setBy(String by) { this.by = by; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
