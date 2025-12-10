package com.civrt.app.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Issue {
    private String id;
    private String title;
    private String category;
    private String description;

    // legacy/simple fields
    private String locationText;        // used by controller
    private Double lat;
    private Double lng;

    // composite objects
    private Location location;
    private Media media;

    private String priority;
    private String status;
    private String createdBy;
    private Instant createdAt;
    private Instant updatedAt;
    private String assignedTo;

    private List<History> history = new ArrayList<>();
    private List<Image> images = new ArrayList<>(); // uses com.civrt.app.model.Image

    public Issue() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.status = "New";
    }

    // builder (simple)
    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private final Issue i = new Issue();
        public Builder title(String t) { i.setTitle(t); return this; }
        public Builder category(String c) { i.setCategory(c); return this; }
        public Builder description(String d) { i.setDescription(d); return this; }
        public Builder media(Media m) { i.setMedia(m); return this; }
        public Builder location(Location l) { i.setLocation(l); return this; }
        public Builder priority(String p) { i.setPriority(p); return this; }
        public Builder status(String s) { i.setStatus(s); return this; }
        public Builder createdBy(String c) { i.setCreatedBy(c); return this; }
        public Builder createdAt(Instant at) { i.setCreatedAt(at); return this; }
        public Builder updatedAt(Instant at) { i.setUpdatedAt(at); return this; }
        public Issue build() { return i; }
    }

    // nested types (Location, Media, History)
    public static class Location {
        private Double lat;
        private Double lng;
        private String address;
        private String ward;

        public Location() {}
        public Location(Double lat, Double lng, String address, String ward) {
            this.lat = lat; this.lng = lng; this.address = address; this.ward = ward;
        }
        public Double getLat() { return lat; } public void setLat(Double lat) { this.lat = lat; }
        public Double getLng() { return lng; } public void setLng(Double lng) { this.lng = lng; }
        public String getAddress() { return address; } public void setAddress(String address) { this.address = address; }
        public String getWard() { return ward; } public void setWard(String ward) { this.ward = ward; }
    }

    public static class Media {
        private List<String> images = new ArrayList<>();
        private List<String> videos = new ArrayList<>();
        public Media() {}
        public Media(List<String> images, List<String> videos) {
            this.images = images != null ? images : new ArrayList<>();
            this.videos = videos != null ? videos : new ArrayList<>();
        }
        public List<String> getImages() { return images; } public void setImages(List<String> images) { this.images = images; }
        public List<String> getVideos() { return videos; } public void setVideos(List<String> videos) { this.videos = videos; }
    }

    public static class History {
        private Instant at; private String by; private String action; private String note; private String toStatus;
        private History() {}
        public static HistoryBuilder builder() { return new HistoryBuilder(); }
        public static class HistoryBuilder {
            private final History h = new History();
            public HistoryBuilder at(Instant a) { h.at = a; return this; }
            public HistoryBuilder by(String b) { h.by = b; return this; }
            public HistoryBuilder action(String act) { h.action = act; return this; }
            public HistoryBuilder note(String n) { h.note = n; return this; }
            public HistoryBuilder toStatus(String s) { h.toStatus = s; return this; }
            public History build() { return h; }
        }
        public Instant getAt() { return at; } public void setAt(Instant at) { this.at = at; }
        public String getBy() { return by; } public void setBy(String by) { this.by = by; }
        public String getAction() { return action; } public void setAction(String action) { this.action = action; }
        public String getNote() { return note; } public void setNote(String note) { this.note = note; }
        public String getToStatus() { return toStatus; } public void setToStatus(String toStatus) { this.toStatus = toStatus; }
    }

    // getters + setters (important ones used by controller/service)
    public String getId() { return id; } public void setId(String id) { this.id = id; }

    public String getTitle() { return title; } public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; } public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; } public void setDescription(String description) { this.description = description; }

    public String getLocationText() { return locationText; } public void setLocationText(String locationText) { this.locationText = locationText; }

    public Double getLat() { return lat != null ? lat : (location != null ? location.getLat() : null); }
    public void setLat(Double lat) { this.lat = lat; }

    public Double getLng() { return lng != null ? lng : (location != null ? location.getLng() : null); }
    public void setLng(Double lng) { this.lng = lng; }

    public Location getLocation() { return location; } public void setLocation(Location location) { this.location = location; }

    public Media getMedia() { return media; } public void setMedia(Media media) { this.media = media; }

    public List<Image> getImages() { return images; } public void setImages(List<Image> images) { this.images = images; }

    public List<History> getHistory() { return history; } public void setHistory(List<History> history) { this.history = history; }

    public String getPriority() { return priority; } public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; } public void setStatus(String status) { this.status = status; }

    public String getCreatedBy() { return createdBy; } public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public Instant getCreatedAt() { return createdAt; } public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; } public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    public String getAssignedTo() { return assignedTo; } public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Issue)) return false;
        Issue issue = (Issue) o;
        return Objects.equals(id, issue.id);
    }
    @Override
    public int hashCode() { return id != null ? id.hashCode() : 0; }
}
