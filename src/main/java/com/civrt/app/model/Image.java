package com.civrt.app.model;

import org.springframework.data.annotation.Id;

public class Image {
    private String url;
    private String publicId;

    public Image() {}

    public Image(String url, String publicId) {
        this.url = url;
        this.publicId = publicId;
    }

    // getters & setters
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getPublicId() { return publicId; }
    public void setPublicId(String publicId) { this.publicId = publicId; }
}
