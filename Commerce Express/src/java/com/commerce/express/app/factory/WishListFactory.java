package com.commerce.express.app.factory;

import com.commerce.express.domain.WishList;
import com.commerce.express.domain.WishListLine;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cna canal walk
 */
public class WishListFactory {

    private WishListFactory() {
    }

    public static WishList getWishList(String wishListID, Date dateCreated, Date dateModified, List<WishListLine> wishListLines) {
        WishList wishList = new WishList();
        wishList.setDateCreated(dateCreated);
        wishList.setDateModified(dateModified);
        wishList.setWishListLines(wishListLines);
        wishList.setWishListID(wishListID);
        return wishList;
    }
}
