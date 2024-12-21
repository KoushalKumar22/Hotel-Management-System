package com.HotelManagementSystem.Rating_Service.DTO;

import java.util.List;

public class RatingDTO {
    private int userId;
    private List<CategoryRating> categoryRatings;

    public static class CategoryRating{
        private String category;
        private int ratingScore;
        private String comment;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CategoryRating> getCategoryRatings() {
        return categoryRatings;
    }

    public void setCategoryRatings(List<CategoryRating> categoryRatings) {
        this.categoryRatings = categoryRatings;
    }
}
