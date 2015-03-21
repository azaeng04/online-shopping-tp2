package com.commerce.express.client.webservice.rest.resources;

import com.commerce.express.domain.OrderLine;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author cna canal walk
 */
public class OrderLineResource extends ResourceSupport {

    private OrderLine orderLine;

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }
}
