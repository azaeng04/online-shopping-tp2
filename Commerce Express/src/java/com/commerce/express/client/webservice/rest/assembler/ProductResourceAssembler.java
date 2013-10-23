/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.webservice.rest.assembler;

import com.commerce.express.client.webservice.rest.Rest;
import com.commerce.express.client.webservice.rest.resources.ProductResource;
import com.commerce.express.domain.Product;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 *
 * @author cna canal walk
 */
@Service("productResourceAssembler")
public class ProductResourceAssembler extends ResourceAssemblerSupport<Product, ProductResource> {

    public ProductResourceAssembler() {
        super(Rest.class, ProductResource.class);
    }

    @Override
    public ProductResource toResource(Product t) {
        ProductResource resource = instantiateResource(t);
        resource.setProduct(t);
        resource.add(linkTo(Rest.class).slash(t.getId()).withSelfRel());
        return resource;
    }
}
