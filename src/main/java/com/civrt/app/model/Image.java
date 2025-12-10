package com.civrt.app.model;

public class Image {
    private String id;
    private String url;
    private String publicId;
    private String format;
    private Long size;
    private String caption;

    public Image() {}
    // getters & setters
    public String getId() { return id; } public void setId(String id) { this.id = id; }
    public String getUrl() { return url; } public void setUrl(String url) { this.url = url; }
    public String getPublicId() { return publicId; } public void setPublicId(String publicId) { this.publicId = publicId; }
    public String getFormat() { return format; } public void setFormat(String format) { this.format = format; }
    public Long getSize() { return size; } public void setSize(Long size) { this.size = size; }
    public String getCaption() { return caption; } public void setCaption(String caption) { this.caption = caption; }
}
