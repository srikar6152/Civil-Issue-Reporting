package com.civrt.app.dto;

import java.util.List;

/**
 * DTO used by IssueService.create(CreateIssueRequest)
 * Keep field names matching what your controller sends.
 */
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

    public CreateIssueRequest() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getImages() { return images; }
    public void setImages(List<String> images) { this.images = images; }

    public List<String> getVideos() { return videos; }
    public void setVideos(List<String> videos) { this.videos = videos; }

    public Double getLat() { return lat; }
    public void setLat(Double lat) { this.lat = lat; }

    public Double getLng() { return lng; }
    public void setLng(Double lng) { this.lng = lng; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getWard() { return ward; }
    public void setWard(String ward) { this.ward = ward; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}
