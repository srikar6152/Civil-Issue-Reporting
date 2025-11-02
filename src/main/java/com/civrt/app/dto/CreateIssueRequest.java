
package com.civrt.app.dto;

import lombok.Data;
import java.util.List;

@Data
public class CreateIssueRequest {
    private String title;
    private String category;
    private String description;
    private List<String> images;
    private List<String> videos;
    private Double lat;
    private Double lng;
    private String address;
    private String ward;
    private String priority;
    private String createdBy;
}
