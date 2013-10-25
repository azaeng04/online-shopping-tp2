/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.webservice.rest.assembler;

import com.commerce.express.client.webservice.rest.CustomerRest;
import com.commerce.express.client.webservice.rest.resources.CustomerResource;
import com.commerce.express.domain.Customer;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 *
 * @author cna canal walk
 */
@Service("customerAssembler")
public class CustomerAssembler extends ResourceAssemblerSupport<Customer, CustomerResource> {

    public CustomerAssembler() {
        super(CustomerRest.class, CustomerResource.class);
    }

    @Override
    public CustomerResource toResource(Customer t) {
        CustomerResource resource = instantiateResource(t);
        resource.setCustomer(t);
        resource.add(linkTo(CustomerRest.class).slash(t.getId()).withSelfRel());
        return resource;
    }
}
