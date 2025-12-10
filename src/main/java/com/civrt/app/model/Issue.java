package com.civrt.app.model;

import java.util.List;
import java.util.ArrayList;

public class Issue {
    private Long id;
    private String title;
    private String category;
    private String description;
    private String locationText;
    private Double lat;
    private Double lng;
    private List<Image> images = new ArrayList<>();

    public Issue() {}

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocationText() { return locationText; }
    public void setLocationText(String locationText) { this.locationText = locationText; }

    public Double getLat() { return lat; }
    public void setLat(Double lat) { this.lat = lat; }

    public Double getLng() { return lng; }
    public void setLng(Double lng) { this.lng = lng; }

    public List<Image> getImages() { return images; }
    public void setImages(List<Image> images) { this.images = images; }
}
