package com.civrt.app.model;

public class Image {
    private String id;
    private String url;
    private String publicId;
    private String caption;

    public Image() {}

    public Image(String url, String publicId) {
        this.url = url;
        this.publicId = publicId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getPublicId() { return publicId; }
    public void setPublicId(String publicId) { this.publicId = publicId; }

    public String getCaption() { return caption; }
    public void setCaption(String caption) { this.caption = caption; }
}
