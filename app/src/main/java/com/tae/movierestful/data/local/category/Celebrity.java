package com.tae.movierestful.data.local.category;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class Celebrity implements CommonCategory {

    private long id;
    private String title;
    private String image;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return CategoryType.CELEBRITY;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
