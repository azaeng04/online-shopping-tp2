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

        private String ratingID = "RAT_";
        private Integer ratingNumber;
        private String ratingStatus;
        private Integer ratingQuantity;
        private Product product;

        public Builder(String ratingID) {
            this.ratingID += ratingID;
        }

        public Builder setRatingNumber(Integer ratingNumber) {
            this.ratingNumber = ratingNumber;
            return this;
        }

        public Builder setRatingStatus(String ratingStatus) {
            this.ratingStatus = ratingStatus;
            return this;
        }

        public Builder setRatingQuantity(Integer ratingQuantity) {
            this.ratingQuantity = ratingQuantity;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
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
