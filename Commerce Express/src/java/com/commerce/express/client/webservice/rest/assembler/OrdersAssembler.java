/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.webservice.rest.assembler;

import com.commerce.express.client.webservice.rest.Rest;
import com.commerce.express.client.webservice.rest.resources.OrdersResource;
import com.commerce.express.domain.Orders;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 *
 * @author cna canal walk
 */
@Service("ordersAssembler")
public class OrdersAssembler extends ResourceAssemblerSupport<Orders, OrdersResource> {

    public OrdersAssembler() {
        super(Rest.class, OrdersResource.class);
    }

    @Override
    public OrdersResource toResource(Orders t) {
        OrdersResource resource = instantiateResource(t);
        resource.setOrders(t);
        resource.add(linkTo(Rest.class).slash(t.getId()).withSelfRel());
        return resource;
    }
}
