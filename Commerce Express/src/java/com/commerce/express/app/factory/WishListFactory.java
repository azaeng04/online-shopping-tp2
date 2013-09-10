/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Product;
import com.commerce.express.domain.WishList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cna canal walk
 */
public class WishListFactory {

    public static WishList getWishList(Date dateCreated, Date dateModified, int quantity, List<Product> products) {
        WishList wishlist = new WishList();
        wishlist.setDateCreated(dateCreated);
        wishlist.setDateModified(dateModified);
        wishlist.setQuantity(quantity);
        wishlist.setProducts(products);
        return wishlist;
    }
}
