/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Product;
import com.commerce.express.domain.Rating;

/**
 *
 * @author cna canal walk
 */
public class RatingFactory {

    public static class Builder {

        private String ratingID;
        private Integer ratingNumber;
        private String ratingStatus;
        private Integer ratingQuantity;
        private Product product;

        public Builder(String ratingID) {
            this.ratingID += ratingID;
        }

        public void setRatingNumber(Integer ratingNumber) {
            this.ratingNumber = ratingNumber;
        }

        public void setRatingStatus(String ratingStatus) {
            this.ratingStatus = ratingStatus;
        }

        public void setRatingQuantity(Integer ratingQuantity) {
            this.ratingQuantity = ratingQuantity;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public Rating buildRating() {
            return buildRating(this);
        }

        private Rating buildRating(Builder object) {
            Rating rating = new Rating();
            rating.setRatingID(object.ratingID);
            rating.setRatingNumber(object.ratingNumber);
            rating.setRatingStatus(object.ratingStatus);
            rating.setRatingQuantity(object.ratingQuantity);
            rating.setProduct(product);
            return rating;
        }
    }
}
