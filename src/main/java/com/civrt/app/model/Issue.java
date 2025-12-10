package com.civrt.app.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Plain Java model for Issue compatible with usages in your service/controller.
 * This is not a JPA entity. If you want JPA later, convert and add annotations.
 */
public class Issue {
    private Long id;
    private String title;
    private String category;
    private String description;
    private Location location;
    private Double lat;
    private Double lng;
    private List<Media> media = new ArrayList<>();
    private List<Image> images = new ArrayList<>(); // keep compatibility if images used elsewhere

    private List<History> history = new ArrayList<>();

    private Instant createdAt;
    private String createdBy;
    private Instant updatedAt;
    private String status;
    private String assignedTo;

    public Issue() {
        this.createdAt = Instant.now();
        this.status = "New";
    }

    /* ========== simple builder ========== */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Issue instance = new Issue();

        public Builder id(Long id) { instance.setId(id); return this; }
        public Builder title(String title) { instance.setTitle(title); return this; }
        public Builder category(String category) { instance.setCategory(category); return this; }
        public Builder description(String description) { instance.setDescription(description); return this; }
        public Builder location(Location location) { instance.setLocation(location); return this; }
        public Builder media(Media media) {
            if (media != null) instance.getMedia().add(media);
            return this;
        }
        public Builder createdBy(String by) { instance.setCreatedBy(by); return this; }
        public Builder status(String status) { instance.setStatus(status); return this; }
        public Builder createdAt(Instant at) { instance.setCreatedAt(at); return this; }

        public Issue build() { return instance; }
    }

    /* ========== nested helper classes ========== */

    public static class Location {
        private Double lat;
        private Double lng;
        private String address;
        private String ward;

        public Location() {}

        public Location(Double lat, Double lng, String address, String ward) {
            this.lat = lat;
            this.lng = lng;
            this.address = address;
            this.ward = ward;
        }

        public Double getLat() { return lat; }
        public void setLat(Double lat) { this.lat = lat; }

        public Double getLng() { return lng; }
        public void setLng(Double lng) { this.lng = lng; }

        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        public String getWard() { return ward; }
        public void setWard(String ward) { this.ward = ward; }
    }

    public static class Media {
        private String url;
        private String publicId;
        private String caption;

        public Media() {}
        public Media(String url, String publicId) { this.url = url; this.publicId = publicId; }

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }

        public String getPublicId() { return publicId; }
        public void setPublicId(String publicId) { this.publicId = publicId; }

        public String getCaption() { return caption; }
        public void setCaption(String caption) { this.caption = caption; }
    }

    /**
     * A simple History record class with builder() to match usages like:
     * Issue.History.builder().at(...).by(...).action(...).note(...).toStatus(...).build()
     */
    public static class History {
        private Instant at;
        private String by;
        private String action;
        private String note;
        private String toStatus;

        private History() {}

        public static HistoryBuilder builder() { return new HistoryBuilder(); }

        public static class HistoryBuilder {
            private final History h = new History();
            public HistoryBuilder at(Instant at) { h.at = at; return this; }
            public HistoryBuilder by(String by) { h.by = by; return this; }
            public HistoryBuilder action(String action) { h.action = action; return this; }
            public HistoryBuilder note(String note) { h.note = note; return this; }
            public HistoryBuilder toStatus(String s) { h.toStatus = s; return this; }
            public History build() { return h; }
        }

        public Instant getAt() { return at; }
        public void setAt(Instant at) { this.at = at; }

        public String getBy() { return by; }
        public void setBy(String by) { this.by = by; }

        public String getAction() { return action; }
        public void setAction(String action) { this.action = action; }

        public String getNote() { return note; }
        public void setNote(String note) { this.note = note; }

        public String getToStatus() { return toStatus; }
        public void setToStatus(String toStatus) { this.toStatus = toStatus; }
    }

    /* ========== image shim (if other code uses Image model) ========== */
    // Keep a minimal Image class (if you already have one, ensure package matches)
    // If you already created com.civrt.app.model.Image, ignore this.
    public static class Image {
        private Long id;
        private String url;
        private String publicId;
        public Image() {}
        public Image(String url, String publicId) { this.url = url; this.publicId = publicId; }
        public Long getId() { return id; } public void setId(Long id) { this.id = id; }
        public String getUrl() { return url; } public void setUrl(String url) { this.url = url; }
        public String getPublicId() { return publicId; } public void setPublicId(String publicId) { this.publicId = publicId; }
    }

    /* ========== getters & setters ========== */

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    // convenience for earlier code which used lat/lng on Issue directly
    public Double getLat() { return lat != null ? lat : (location != null ? location.getLat() : null); }
    public void setLat(Double lat) { this.lat = lat; }

    public Double getLng() { return lng != null ? lng : (location != null ? location.getLng() : null); }
    public void setLng(Double lng) { this.lng = lng; }

    public List<Media> getMedia() { return media; }
    public void setMedia(List<Media> media) { this.media = media; }

    public List<Image> getImages() { return images; }
    public void setImages(List<Image> images) { this.images = images; }

    public List<History> getHistory() { return history; }
    public void setHistory(List<History> history) { this.history = history; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;
        return Objects.equals(id, issue.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
