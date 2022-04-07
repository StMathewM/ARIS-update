package com.example.mobile_aris.bites;

public class hreport {
    String username,photo,type,description, r_createdAt;
    String admin,text,createdAt;

    public hreport(String username, String photo, String type, String description, String r_createdAt, String admin, String text, String createdAt) {
        this.username = username;
        this.photo = photo;
        this.type = type;
        this.description = description;
        this.r_createdAt = r_createdAt;
        this.admin = admin;
        this.text = text;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getR_createdAt() {
        return r_createdAt;
    }

    public void setR_createdAt(String r_createdAt) {
        this.r_createdAt = r_createdAt;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
