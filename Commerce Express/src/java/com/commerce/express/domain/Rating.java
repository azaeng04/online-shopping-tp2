/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.codehaus.jackson.annotate.JsonBackReference;

/**
 *
 * @author Owner
 */
@Entity
public class Rating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String ratingID;
    private Integer ratingNumber;
    private String ratingStatus;
    private Integer ratingQuantity;
    
    @JsonBackReference
    @OneToOne
    private Product product;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference
    public Product getProduct() {
        return product;
    }

    @JsonBackReference
    public void setProduct(Product product) {
        this.product = product;
    }

    public String getRatingID() {
        return ratingID;
    }

    public void setRatingID(String ratingID) {
        this.ratingID = ratingID;
    }

    public Integer getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(Integer ratingNumber) {
        this.ratingNumber = ratingNumber;
    }

    public String getRatingStatus() {
        return ratingStatus;
    }

    public void setRatingStatus(String ratingStatus) {
        this.ratingStatus = ratingStatus;
    }

    public Integer getRatingQuantity() {
        return ratingQuantity;
    }

    public void setRatingQuantity(Integer ratingQuantity) {
        this.ratingQuantity = ratingQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.commerce.express.domain.Rating[ id=" + id + " ]";
    }
    
}
