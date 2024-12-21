package com.UserMicroServices.Registration_Service.DTO;

public class RatingsDTO {
    private int userId;
    private String category;
    private int ratingScore;
    private String comment;

    public RatingsDTO(int id, String category, int ratingScore, String comment) {
        userId = id;
        this.category = category;
        this.ratingScore = ratingScore;
        this.comment = comment;
    }

    public RatingsDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
