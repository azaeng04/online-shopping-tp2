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
    
    public static Rating getRating(Product product, int ratingnumber, String ratingStatus, String ratingQuantity) {
        Rating rating = new Rating();
        rating.setRatingNumber(ratingnumber);
        rating.setRatingStatus(ratingStatus);
        rating.setRatingQuantity(ratingnumber);
        rating.setProduct(product);
        return rating;
    }
}
