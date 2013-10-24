/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.webservice.rest.assembler;

import com.commerce.express.client.webservice.rest.Rest;
import com.commerce.express.client.webservice.rest.resources.OrderLineResource;
import com.commerce.express.domain.OrderLine;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 *
 * @author cna canal walk
 */
@Service("orderLineAssembler")
public class OrderLineAssembler extends ResourceAssemblerSupport<OrderLine, OrderLineResource> {

    public OrderLineAssembler() {
        super(Rest.class, OrderLineResource.class);
    }

    @Override
    public OrderLineResource toResource(OrderLine t) {
        OrderLineResource resource = instantiateResource(t);
        resource.setOrderLine(t);
        resource.add(linkTo(Rest.class).slash(t.getId()).withSelfRel());
        return resource;
    }
}
