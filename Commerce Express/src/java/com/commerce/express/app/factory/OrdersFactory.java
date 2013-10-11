/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Orders;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cna canal walk
 */
public class OrdersFactory {

    public static class Builder {

        private String orderID = "ORD_";
        private Date dateCreated;
        private Date dateModified;
        private String status;
        private List<OrderLine> orderLines;

        public Builder(String orderID) {
            this.orderID += orderID;
        }

        public Builder setDateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Builder setDateModified(Date dateModified) {
            this.dateModified = dateModified;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setOrderLines(List<OrderLine> orderLines) {
            this.orderLines = orderLines;
            return this;
        }

        public Orders buildOrder() {
            return buildOrder(this);
        }

        private Orders buildOrder(Builder object) {
            Orders orders = new Orders();
            orders.setOrderID(object.orderID);
            orders.setDateModified(object.dateModified);
            orders.setDateCreated(object.dateCreated);
            orders.setOrderLines(object.orderLines);
            orders.setStatus(object.status);
            return orders;
        }
    }
}