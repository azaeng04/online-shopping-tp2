/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Product;
import com.commerce.express.domain.WishListLine;

/**
 *
 * @author Ronald
 */
public class WishListLineFactory {

    private WishListLineFactory() {
    }
    
    public static WishListLine getWishListLine(String wishListLineID, Product product) {
        WishListLine wishListLine = new WishListLine();
        wishListLine.setWishListLineID(wishListLineID);
        wishListLine.setProduct(product);
        return wishListLine;
    }
}
