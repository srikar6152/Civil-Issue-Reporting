package com.civrt.app.model;

public class Image {
    private Long id;
    private String url;
    private String publicId; // cloudinary/etc id

    public Image() {}

    public Image(String url, String publicId) {
        this.url = url;
        this.publicId = publicId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getPublicId() { return publicId; }
    public void setPublicId(String publicId) { this.publicId = publicId; }
}
