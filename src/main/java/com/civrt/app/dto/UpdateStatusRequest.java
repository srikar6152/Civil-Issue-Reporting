
package com.civrt.app.dto;

import lombok.Data;

@Data
public class UpdateStatusRequest {
    private String status; // New/In-Review/In-Progress/Resolved/Rejected
    private String by;     // user performing change
    private String note;
}
