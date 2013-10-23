/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.webservice.rest;

import com.commerce.express.client.webservice.rest.assembler.ProductResourceAssembler;
import com.commerce.express.client.webservice.rest.resources.ProductResource;
import com.commerce.express.domain.Product;
import com.commerce.express.service.rest.ProductRestService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author cna canal walk
 */
@Controller
@RequestMapping("api")
public class Rest {

    @Autowired
    private ProductRestService productRestService;
    @Autowired
    private ProductResourceAssembler productResourceAssembler;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProductResource>> getProduct() {
        List<Product> products = productRestService.getProducts();
        List<ProductResource> resource = productResourceAssembler.toResources(products);
        return new ResponseEntity<List<ProductResource>>(resource, HttpStatus.OK);
    }
    
    
    
    
}
