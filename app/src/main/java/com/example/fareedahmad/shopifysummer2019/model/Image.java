package com.example.fareedahmad.shopifysummer2019.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("width")
    private int width;

    @SerializedName("height")
    private int height;

    @SerializedName("src")
    private String src;

    public Image(int width, int height, String src) {
        this.width = width;
        this.height = height;
        this.src = src;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
