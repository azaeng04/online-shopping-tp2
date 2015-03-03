/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.webservice.rest.assembler;

import com.commerce.express.client.webservice.rest.ProductRest;
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
public class ProductAssembler extends ResourceAssemblerSupport<Product, ProductResource> {

    public ProductAssembler() {
        super(ProductRest.class, ProductResource.class);
    }

    @Override
    public ProductResource toResource(Product product) {
        ProductResource prodResource = instantiateResource(product);
        prodResource.setProduct(product);
        prodResource.add(linkTo(ProductRest.class).slash(product.getId()).withSelfRel());
        return prodResource;
    }
}
