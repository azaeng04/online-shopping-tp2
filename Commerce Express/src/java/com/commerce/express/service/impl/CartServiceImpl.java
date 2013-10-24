/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.domain.Product;
import com.commerce.express.service.CartService;
import java.text.DecimalFormat;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author om95446
 */
@Service("CartService")
public class CartServiceImpl implements CartService {
    CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    
    private static CartServiceImpl objServiceImpl;

    private CartServiceImpl() {
    }

    public synchronized static CartServiceImpl getInstance() {
        if (objServiceImpl == null) {
            objServiceImpl = new CartServiceImpl();
        }
        return objServiceImpl;
    }

    @Override
    public String displayCart(Map<String, String> cart) {
        String table = "";
        String productID;
        String quantity;
        Product product;
        Double subtotal;
        if (!cart.isEmpty()) {
            DecimalFormat decimalFormat = new DecimalFormat("###########.00");
            Double grandTotal = 0.0;
            table = "<form method='POST' action='checkout'>";
            table +="<table class='table table-bordered table-hover'>";
            table +="<th>Product ID</th>";
            table +="<th>Product Name</th>";
            table +="<th>Product Price</th>";
            table +="<th>Quantity</th>";
            table +="<th>Subtotal</th>";
            for (Map.Entry<String, String> entry : cart.entrySet()) {
                productID = entry.getKey();
                quantity = entry.getValue();
                product = commerceExpressCRUD.getProductCrudService().findById(Long.parseLong(productID));
                subtotal = new Double(product.getProductPrice()) * new Integer(quantity);
                table +="<tr>";
                table +="<td>" + productID + "</td>";
                table +="<td>" + product.getProductName() + "</td>";
                table +="<td>R" + product.getProductPrice() + "</td>";
                table +="<td><input type'text' name='qty" + product.getId() + "' value='" + quantity + "' readonly='true' /></td>";
                table +="<td>R" + decimalFormat.format(subtotal) + "</td>";
                table +="</tr>";
                grandTotal += subtotal;
            }
            table +="<tr>";
            table +="<td colspan='4' style='text-align: right'>Grand Total </td>";
            table +="<td>R" + decimalFormat.format(grandTotal) + "</td>";
            table +="</tr>";
            table +="</table>";
            table +="<input type='submit' class='btn btn-primary btn-large' value='Checkout'/>";
            table +="</form>";
        }
        return table;
    }
}
