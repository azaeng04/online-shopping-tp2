/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Owner
 */
@Embeddable
public class ProductStatus implements Serializable{
    private String status;
    private Integer inStock;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }
}
